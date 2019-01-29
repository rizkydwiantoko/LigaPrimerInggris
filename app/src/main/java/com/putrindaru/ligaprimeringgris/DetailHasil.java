package com.putrindaru.ligaprimeringgris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHasil extends AppCompatActivity {

    ImageView ivDetHasil;
    TextView tvDetHasilVS;
    TextView tvDetHasilSkorHome;
    TextView tvDetHasilSkorAway;
    TextView tvDetHasilTgl;
    TextView tvDetHasilTimHome;
    TextView tvDetHasilPencetakH;
    TextView tvDetHasilKuningH;
    TextView tvDetHasilMerahH;
    TextView tvDetHasilTimAway;
    TextView tvDetHasilPencetakA;
    TextView tvDetHasilKuningA;
    TextView tvDetHasilMerahA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hasil);

        setTitle(R.string.hasil);

        ivDetHasil = findViewById(R.id.ivDetHasil);
        tvDetHasilVS = findViewById(R.id.tvDetHasilVS);
        tvDetHasilSkorHome = findViewById(R.id.tvDetHasilSkorHome);
        tvDetHasilSkorAway = findViewById(R.id.tvDetHasilSkorAway);
        tvDetHasilTgl = findViewById(R.id.tvDetHasilTgl);
        tvDetHasilTimHome = findViewById(R.id.tvDetHasilTimHome);
        tvDetHasilPencetakH = findViewById(R.id.tvDetHasilPencetakH);
        tvDetHasilKuningH = findViewById(R.id.tvDetHasilKuningH);
        tvDetHasilMerahH = findViewById(R.id.tvDetHasilMerahH);
        tvDetHasilTimAway = findViewById(R.id.tvDetHasilTimAway);
        tvDetHasilPencetakA = findViewById(R.id.tvDetHasilPencetakA);
        tvDetHasilKuningA = findViewById(R.id.tvDetHasilKuningA);
        tvDetHasilMerahA = findViewById(R.id.tvDetHasilMerahA);

        HasilItems detHasil  = getIntent().getParcelableExtra("extra_soccer");

        //untuk menampilkan gambar poster film menggunakan picasso
        com.squareup.picasso.Picasso.with(this).
                load(String.valueOf(detHasil.getGambarHasil().toString())).
                placeholder(R.mipmap.ic_launcher).
                into(ivDetHasil);

        tvDetHasilVS.setText(String.valueOf(detHasil.getVsHasil()));
        tvDetHasilSkorHome.setText(String.valueOf(detHasil.getHomeSkorHasil()));
        tvDetHasilSkorAway.setText(String.valueOf(detHasil.getAwaySkorhasil()));
        tvDetHasilTgl.setText(String.valueOf(detHasil.getTglHasil()));
        tvDetHasilTimHome.setText(String.valueOf(detHasil.getHomeTimHasil()));
        tvDetHasilPencetakH.setText(String.valueOf(detHasil.getGolSkorerHomeHasil()));
        tvDetHasilKuningH.setText(String.valueOf(detHasil.getYellowCardHomeHasil()));
        tvDetHasilMerahH.setText(String.valueOf(detHasil.getRedCardHomeHasil()));
        tvDetHasilTimAway.setText(String.valueOf(detHasil.getAwayTimhasil()));
        tvDetHasilPencetakA.setText(String.valueOf(detHasil.getGolSkorerAwayhasil()));
        tvDetHasilKuningA.setText(String.valueOf(detHasil.getYellowCardAwayHasil()));
        tvDetHasilMerahA.setText(String.valueOf(detHasil.getRedCardAwayHasil()));

    }
}
