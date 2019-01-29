package com.putrindaru.ligaprimeringgris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailKlub extends AppCompatActivity {

    ImageView ivDetKlub;
    ImageView ivGbrStadion;
    TextView tvNamaKlub;
    TextView tvJulukanKlub;
    TextView tvAsalKlub;
    TextView tvTahunKlub;
    TextView tvWebsiteKlub;
    TextView tvPelatihKlub;
    TextView tvDeskripsiKlub;
    TextView tvStadionKlub;
    TextView tvKapasitasKlub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_klub);

        setTitle(R.string.detail_klub);

        ivDetKlub = findViewById(R.id.ivDetKlub);
        ivGbrStadion = findViewById(R.id.ivGbrStadion);
        tvNamaKlub = findViewById(R.id.tvNamaKlub);
        tvJulukanKlub = findViewById(R.id.tvJulukanKlub);
        tvAsalKlub = findViewById(R.id.tvAsalKlub);
        tvTahunKlub = findViewById(R.id.tvTahunKlub);
        tvWebsiteKlub = findViewById(R.id.tvWebsiteKlub);
        tvPelatihKlub = findViewById(R.id.tvPelatihKlub);
        tvDeskripsiKlub = findViewById(R.id.tvDeskripsiKlub);
        tvStadionKlub = findViewById(R.id.tvStadionKlub);
        tvKapasitasKlub = findViewById(R.id.tvKapasitasKlub);

        KlubItems detKlub  = getIntent().getParcelableExtra("extra_klub");

        com.squareup.picasso.Picasso.with(this).
                load(String.valueOf(detKlub.getKlubBanner().toString())).
                placeholder(R.mipmap.ic_launcher).
                into(ivDetKlub);

        com.squareup.picasso.Picasso.with(this).
                load(String.valueOf(detKlub.getGbrStadion().toString())).
                placeholder(R.mipmap.ic_launcher).
                into(ivGbrStadion);

        tvNamaKlub.setText(String.valueOf(detKlub.getTvNamaKlub()));
        tvJulukanKlub.setText(String.valueOf(detKlub.getKlubAlias()));
        tvAsalKlub.setText(String.valueOf(detKlub.getTvMarkas()));
        tvTahunKlub.setText(String.valueOf(detKlub.getTvTahunBerdiri()));
        tvWebsiteKlub.setText(String.valueOf(detKlub.getKlubWebsite()));
        tvPelatihKlub.setText(String.valueOf(detKlub.getTvPelatih()));
        tvDeskripsiKlub.setText(String.valueOf(detKlub.getKlubDeskripsi()));
        tvStadionKlub.setText(String.valueOf(detKlub.getTvStadion()));
        tvKapasitasKlub.setText(String.valueOf(detKlub.getKlubKapasitas()));

    }
}
