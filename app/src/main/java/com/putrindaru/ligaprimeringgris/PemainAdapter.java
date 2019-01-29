package com.putrindaru.ligaprimeringgris;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PemainAdapter extends BaseAdapter {
    private ArrayList<PemainItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;

    public PemainAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<PemainItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final PemainItems item) {
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
    public PemainItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {
        ImageView ivPotoPemain;
        TextView tvNamaPemain;
        TextView tvNegaraPemain;
        TextView tvTTLPemain;
        TextView tvTBPemain;
        TextView tvPosisiPemain;
        TextView beratPemain;
        TextView tpLahirPemain;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        PemainAdapter.dataBola attribut = null;

        if (convertView == null) {
            attribut = new PemainAdapter.dataBola( );
            convertView = mInflater.inflate(R.layout.pemain_items, null);
            attribut.ivPotoPemain = convertView.findViewById(R.id.ivPotoPemain);
            attribut.tvNamaPemain = convertView.findViewById(R.id.tvNamaPemain);
            attribut.tvNegaraPemain = (TextView) convertView.findViewById(R.id.tvNegaraPemain);
            attribut.tvTTLPemain = (TextView) convertView.findViewById(R.id.tvTTLPemain);
            attribut.tvTBPemain = (TextView) convertView.findViewById(R.id.tvTBPemain);
            attribut.tvPosisiPemain = convertView.findViewById(R.id.tvPosisiPemain);


            convertView.setTag(attribut);
        } else {
            attribut = (PemainAdapter.dataBola) convertView.getTag( );
        }

        attribut.tvNamaPemain.setText(mData.get(position).getTvNamaPemain());
        attribut.tvNegaraPemain.setText(mData.get(position).getTvNegaraPemain());
        attribut.tvTTLPemain.setText(mData.get(position).getTpLahirPemain()+" / "+mData.get(position).getTvTTLPemain());
        attribut.tvTBPemain.setText(mData.get(position).getTvTBPemain()+"m / "+mData.get(position).getBeratPemain()+"kg");
        attribut.tvPosisiPemain.setText(mData.get(position).getTvPosisiPemain());
        com.squareup.picasso.Picasso.with(context).
                load(mData.get(position).getIvPotoPemain()).
                placeholder(R.mipmap.ic_launcher).
                into(attribut.ivPotoPemain);

        return convertView;
    }
}
