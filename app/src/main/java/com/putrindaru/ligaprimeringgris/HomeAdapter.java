package com.putrindaru.ligaprimeringgris;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeAdapter extends BaseAdapter {
    private ArrayList<HomeItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<HomeItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final HomeItems item) {
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
    public HomeItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {
        ImageView ivHomePoster;
        ImageView ivHomeBanner;
        TextView tvHomeJenisLiga;
        TextView tvHomeNamaLiga;
        TextView tvHomeNegaraLiga;
        TextView tvHomeWebLiga;
        TextView tvHomeDeskLiga;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HomeAdapter.dataBola attribut = null;

        if (convertView == null) {
            attribut = new HomeAdapter.dataBola( );
            convertView = mInflater.inflate(R.layout.home_items, null);
            attribut.ivHomePoster = convertView.findViewById(R.id.ivHomePoster);
            attribut.ivHomeBanner = convertView.findViewById(R.id.ivHomeBanner);
            attribut.tvHomeJenisLiga = (TextView) convertView.findViewById(R.id.tvHomeJenisLiga);
            attribut.tvHomeNamaLiga = (TextView) convertView.findViewById(R.id.tvHomeNamaLiga);
            attribut.tvHomeNegaraLiga = (TextView) convertView.findViewById(R.id.tvHomeNegaraLiga);
            attribut.tvHomeWebLiga = convertView.findViewById(R.id.tvHomeWebLiga);
            attribut.tvHomeDeskLiga = convertView.findViewById(R.id.tvHomeDeskLiga);

            convertView.setTag(attribut);
        } else {
            attribut = (HomeAdapter.dataBola) convertView.getTag( );
        }

        attribut.tvHomeJenisLiga.setText(mData.get(position).getTvHomeJenisLiga());
        attribut.tvHomeNamaLiga.setText(mData.get(position).getTvHomeNamaLiga());
        attribut.tvHomeNegaraLiga.setText(mData.get(position).getTvHomeNegaraLiga());
        attribut.tvHomeWebLiga.setText(mData.get(position).getTvHomeWebLiga());
        attribut.tvHomeDeskLiga.setText(mData.get(position).getTvHomeDeskLiga());
        com.squareup.picasso.Picasso.with(context).
                load(mData.get(position).getIvHomePoster()).
                placeholder(R.mipmap.ic_launcher).
                into(attribut.ivHomePoster);

        com.squareup.picasso.Picasso.with(context).
                load(mData.get(position).getIvHomeBanner()).
                placeholder(R.mipmap.ic_launcher).
                into(attribut.ivHomeBanner);

        return convertView;
    }
}
