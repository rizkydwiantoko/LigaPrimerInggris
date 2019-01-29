package com.putrindaru.ligaprimeringgris;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DaftarPemain extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<PemainItems>> {

    ListView listView;
    PemainAdapter adapter;

    static final String EXTRA_KLUB = "EXTRA_KLUB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pemain);



        adapter = new PemainAdapter(this);
        adapter.notifyDataSetChanged();
        listView = (ListView) findViewById(R.id.listPemain);

        listView.setAdapter(adapter);

        Intent intent  = getIntent();
        String idKlub = intent.getStringExtra("extra_pemain");
        String nmKlub = intent.getStringExtra("extra_namaklub");

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KLUB, idKlub);

        setTitle(nmKlub);

        getLoaderManager().initLoader(0, bundle, this);
    }

    @NonNull
    @Override
    public Loader<ArrayList<PemainItems>> onCreateLoader(int i, @Nullable Bundle bundle) {
        String idKlubs = "";
        if (bundle != null) {
            idKlubs = bundle.getString(EXTRA_KLUB);
        }

        return new PemainAsyncTaskLoader(this, idKlubs);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<PemainItems>> loader, ArrayList<PemainItems> pemainItems) {
        adapter.setData(pemainItems);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<PemainItems>> loader) {
        adapter.setData(null);
    }
}
