package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.AsyncTaskLoader;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class JadwalAsyncTaskLoader extends AsyncTaskLoader<ArrayList<JadwalItems>> {

    private ArrayList<JadwalItems> mData;
    private boolean mHasResult = false;

    public JadwalAsyncTaskLoader(@NonNull Context context) {
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
    public void deliverResult(final ArrayList<JadwalItems> data) {
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
    public ArrayList<JadwalItems> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();

        final ArrayList<JadwalItems> jadwalItemses = new ArrayList<>();

        String url = null;

//        url = "https://apifootball.com/api/?action=get_standings&league_id=62&APIkey="+ API_KEY;
        url = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328";

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
                    JSONArray list = responseObject.getJSONArray("events");
//                    JSONArray list = new JSONArray(result); // jika no array name
                    //menglist item2 didalam header
                    for (int i = 0 ; i < list.length() ; i++){
                        JSONObject jadwal = list.getJSONObject(i);
                        JadwalItems jadwalItems= new JadwalItems(jadwal);
                        jadwalItemses.add(jadwalItems);
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

        return jadwalItemses;
    }

    protected void onReleaseResources(ArrayList<JadwalItems> data) {
        //nothing to do.
    }
}
