package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONException;

import java.security.InvalidKeyException;
import java.util.ArrayList;

public class KlasemenAdapter extends BaseAdapter {

    private ArrayList<KlasemenItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;

    public KlasemenAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<KlasemenItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final KlasemenItems item) {
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
    public KlasemenItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {
        TextView tvPeringkat;
        TextView tvNamaTim;
        TextView tvJmlTanding;
        TextView tvMenang;
        TextView tvSeri;
        TextView tvKalah;
        TextView tvGM;
        TextView tvGK;
        TextView tvPoin;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        dataBola attribut = null;

        if (convertView == null) {
            attribut = new dataBola( );
            convertView = mInflater.inflate(R.layout.klasemen_items, null);
            attribut.tvPeringkat = (TextView) convertView.findViewById(R.id.tvPeringkat);
            attribut.tvNamaTim = (TextView) convertView.findViewById(R.id.tvNamaTim);
            attribut.tvJmlTanding = (TextView) convertView.findViewById(R.id.tvJmlTanding);
            attribut.tvMenang = convertView.findViewById(R.id.tvMenang);
            attribut.tvSeri = convertView.findViewById(R.id.tvSeri);
            attribut.tvKalah = convertView.findViewById(R.id.tvKalah);
            attribut.tvGM = convertView.findViewById(R.id.tvGM);
            attribut.tvGK = convertView.findViewById(R.id.tvGK);
            attribut.tvPoin = convertView.findViewById(R.id.tvPoin);
            convertView.setTag(attribut);
        } else {
            attribut = (dataBola) convertView.getTag( );
        }

            attribut.tvPeringkat.setText(String.valueOf(position+1+"."));
            attribut.tvNamaTim.setText(mData.get(position).getNamaTim( ));
            attribut.tvJmlTanding.setText(String.valueOf(mData.get(position).getJmlTanding( )));

            attribut.tvMenang.setText(String.valueOf(mData.get(position).getMenang( )));
            attribut.tvSeri.setText(String.valueOf(mData.get(position).getSeri( )));
            attribut.tvKalah.setText(String.valueOf(mData.get(position).getKalah( )));

            attribut.tvGM.setText(String.valueOf(mData.get(position).getGolM( )));
            attribut.tvGK.setText(String.valueOf(mData.get(position).getGolK( )));
            attribut.tvPoin.setText(String.valueOf(mData.get(position).getPoin( )));


        return convertView;
    }
}
