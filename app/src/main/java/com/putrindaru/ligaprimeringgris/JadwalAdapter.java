package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class JadwalAdapter extends BaseAdapter {
    private ArrayList<JadwalItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;

    public JadwalAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<JadwalItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final JadwalItems item) {
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
    public JadwalItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {
        TextView tvHomeJadwal;
        TextView tvAwayJadwal;
        TextView tvJadwalTgl;
        TextView tvJadwalJam;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        JadwalAdapter.dataBola attribut = null;

        if (convertView == null) {
            attribut = new JadwalAdapter.dataBola( );
            convertView = mInflater.inflate(R.layout.jadwal_items, null);
            attribut.tvHomeJadwal = (TextView) convertView.findViewById(R.id.tvHomeJadwal);
            attribut.tvAwayJadwal = (TextView) convertView.findViewById(R.id.tvAwayJadwal);
            attribut.tvJadwalTgl = (TextView) convertView.findViewById(R.id.tvJadwalTgl);
            attribut.tvJadwalJam = convertView.findViewById(R.id.tvJadwalJam);

            convertView.setTag(attribut);
        } else {
            attribut = (JadwalAdapter.dataBola) convertView.getTag( );
        }

        String jam = mData.get(position).getJamVersus();
        int panjangJam = jam.length();
        jam = jam.substring(0,5);

        attribut.tvHomeJadwal.setText(mData.get(position).getHomeVersus());
        attribut.tvAwayJadwal.setText(mData.get(position).getAwayVersus());
        attribut.tvJadwalTgl.setText(mData.get(position).getTglVersus());
        attribut.tvJadwalJam.setText(jam);

        return convertView;
    }
}
