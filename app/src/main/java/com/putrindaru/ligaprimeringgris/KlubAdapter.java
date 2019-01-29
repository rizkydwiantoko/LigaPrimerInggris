package com.putrindaru.ligaprimeringgris;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KlubAdapter extends BaseAdapter {
    private ArrayList<KlubItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;
    KlubItems detKlub = new KlubItems();

    public KlubAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<KlubItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final KlubItems item) {
        mData.add(item);
        notifyDataSetChanged( );
    }

    public void clearData() {
        mData.clear( );
    }

    @Override
    public int getItemViewType(int position){
        return 0;
    }

    @Override
    public int getViewTypeCount(){
        return 1;
    }

    @Override
    public int getCount(){
        if (mData == null) return 0;
        return mData.size();
    }

    @Override
    public KlubItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {

        Button btnDetail;
        Button btnPemain;
        ImageView ivKlub;
        TextView tvNamaKlub;
        TextView tvMarkas;
        TextView tvTahunBerdiri;
        TextView tvPelatih;
        TextView tvStadion;
//        TextView klubAlias;
//        TextView klubKapasitas;
//        TextView klubWebsite;
//        TextView klubDeskripsi;
//        ImageView klubBanner;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        KlubAdapter.dataBola attribut = null;

        if (convertView == null) {
            attribut = new KlubAdapter.dataBola( );
            convertView = mInflater.inflate(R.layout.klub_items, null);
            attribut.ivKlub = convertView.findViewById(R.id.ivKlub);
            attribut.tvNamaKlub = convertView.findViewById(R.id.tvNamaKlub);
            attribut.tvMarkas = (TextView) convertView.findViewById(R.id.tvMarkas);
            attribut.tvTahunBerdiri = (TextView) convertView.findViewById(R.id.tvTahunBerdiri);
            attribut.tvPelatih = (TextView) convertView.findViewById(R.id.tvPelatih);
            attribut.tvStadion = convertView.findViewById(R.id.tvStadion);
            attribut.btnDetail = convertView.findViewById(R.id.btnDetail);
            attribut.btnPemain = convertView.findViewById(R.id.btnPemain);

            convertView.setTag(attribut);
        } else {
            attribut = (KlubAdapter.dataBola) convertView.getTag( );
        }

        //jika di klik btn
        final KlubAdapter.dataBola finalAttribut = attribut;
        attribut.btnDetail.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Integer posisi = (int) finalAttribut.btnDetail.getTag();

                detKlub.setKlubBanner(mData.get(posisi).getKlubBanner());
                detKlub.setTvNamaKlub(mData.get(posisi).getTvNamaKlub());
                detKlub.setKlubAlias(mData.get(posisi).getKlubAlias());
                detKlub.setTvMarkas(mData.get(posisi).getTvMarkas());
                detKlub.setTvTahunBerdiri(mData.get(posisi).getTvTahunBerdiri());
                detKlub.setKlubWebsite(mData.get(posisi).getKlubWebsite());
                detKlub.setTvPelatih(mData.get(posisi).getTvPelatih());
                detKlub.setKlubDeskripsi(mData.get(posisi).getKlubDeskripsi());
                detKlub.setTvStadion(mData.get(posisi).getTvStadion());
                detKlub.setKlubKapasitas(mData.get(posisi).getKlubKapasitas());
                detKlub.setGbrStadion(mData.get(posisi).getGbrStadion());

                Intent pindahDetail = new Intent(context, DetailKlub.class); //memulai intent
                pindahDetail.putExtra("extra_klub", detKlub); //data yang akan dikirim ke activity lain
                context.startActivity(pindahDetail); //pindah ke activity lain
            }

        });

        attribut.btnPemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer posisi = (int) finalAttribut.btnDetail.getTag();

                String idKlub = String.valueOf(mData.get(posisi).getIdKlub());
                String nmKlub = String.valueOf(mData.get(posisi).getTvNamaKlub());

                Intent pindahDetail = new Intent(context, DaftarPemain.class); //memulai intent
                pindahDetail.putExtra("extra_pemain", idKlub);
                pindahDetail.putExtra("extra_namaklub", nmKlub);
                context.startActivity(pindahDetail); //pindah ke activity lain
            }
        });

        attribut.btnDetail.setTag(position);
        attribut.tvNamaKlub.setText(mData.get(position).getTvNamaKlub());
        attribut.tvMarkas.setText(mData.get(position).getTvMarkas());
        attribut.tvTahunBerdiri.setText(mData.get(position).getTvTahunBerdiri());
        attribut.tvPelatih.setText(mData.get(position).getTvPelatih());
        attribut.tvStadion.setText(mData.get(position).getTvStadion());
        com.squareup.picasso.Picasso.with(context).
                load(mData.get(position).getIvKlub()).
                placeholder(R.mipmap.ic_launcher).
                into(attribut.ivKlub);

        return convertView;
    }
}
