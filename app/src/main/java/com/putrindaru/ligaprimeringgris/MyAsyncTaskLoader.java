package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MyAsyncTaskLoader extends AsyncTaskLoader<ArrayList<KlasemenItems>> {
    private ArrayList<KlasemenItems> mData;
    private boolean mHasResult = false;

    public MyAsyncTaskLoader(final Context context) {
        super(context);
        onContentChanged();
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
        else if (mHasResult)
            deliverResult(mData);
    }

    @Override
    public void deliverResult(final ArrayList<KlasemenItems> data) {
        mData = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mHasResult) {
            onReleaseResources(mData);
            mData = null;
            mHasResult = false;
        }
    }

//    private static final String API_KEY = "392ec9172413aa9cf28111f7aff58fee202b47c4985e0528b9bf274fb3030db6";

    @Override
    public ArrayList<KlasemenItems> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();

        final ArrayList<KlasemenItems> klasemenItemses = new ArrayList<>();

        String url = null;

//        url = "https://apifootball.com/api/?action=get_standings&league_id=62&APIkey="+ API_KEY;
        url = "https://www.thesportsdb.com/api/v1/json/1/lookuptable.php?l=4328&s=1819";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }

            //mendapatkan header
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("table");
//                    JSONArray list = new JSONArray(result); // jika no array name
                    //menglist item2 didalam header
                    for (int i = 0 ; i < list.length() ; i++){
                        JSONObject klasemen = list.getJSONObject(i);
                        KlasemenItems klasemenItems= new KlasemenItems(klasemen);
                        klasemenItemses.add(klasemenItems);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //Jika response gagal maka , do nothing
            }
        });

        return klasemenItemses;
    }

    protected void onReleaseResources(ArrayList<KlasemenItems> data) {
        //nothing to do.
    }
}
