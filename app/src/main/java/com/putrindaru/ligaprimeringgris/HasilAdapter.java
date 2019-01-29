package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HasilAdapter extends BaseAdapter {
    private ArrayList<HasilItems> mData = new ArrayList<>( );
    private LayoutInflater mInflater;
    private Context context;
    HasilItems detHasil = new HasilItems();

    public HasilAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<HasilItems> items) {
        mData = items;
        notifyDataSetChanged( );
    }

    public void addItem(final HasilItems item) {
        mData.add(item);
        notifyDataSetChanged( );
    }

    public void clearData() {
        mData.clear( );
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        if (mData == null) return 0;
        return mData.size( );
    }

    @Override
    public HasilItems getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class dataBola {
        TextView tvIdHasil;
        TextView tvHomeHasil;
        TextView tvAwayHasil;
        TextView tvHasilTgl;
        TextView tvSkorHomeHasil;
        TextView tvSkorAwayHasil;
        CardView cvHasil;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        HasilAdapter.dataBola attribut = null;

        if (convertView == null) {
            attribut = new HasilAdapter.dataBola( );
            convertView = mInflater.inflate(R.layout.hasil_items, null);
            attribut.tvHomeHasil = (TextView) convertView.findViewById(R.id.tvHomeHasil);
            attribut.tvAwayHasil = (TextView) convertView.findViewById(R.id.tvAwayHasil);
            attribut.tvHasilTgl = (TextView) convertView.findViewById(R.id.tvHasilTgl);
            attribut.tvSkorHomeHasil = convertView.findViewById(R.id.tvSkorHomeHasil);
            attribut.tvSkorAwayHasil = convertView.findViewById(R.id.tvSkorAwayHasil);
            attribut.cvHasil = convertView.findViewById(R.id.cvHasil);

            convertView.setTag(attribut);
        } else {
            attribut = (HasilAdapter.dataBola) convertView.getTag( );
        }

        //jika di klik cv
        final dataBola finalAttribut = attribut;
        attribut.cvHasil.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Integer posisi = (int) finalAttribut.cvHasil.getTag();

                detHasil.setGambarHasil(mData.get(posisi).getGambarHasil());
                detHasil.setVsHasil(mData.get(posisi).getVsHasil());
                detHasil.setHomeSkorHasil(mData.get(posisi).getHomeSkorHasil());
                detHasil.setAwaySkorhasil(mData.get(posisi).getAwaySkorhasil());
                detHasil.setTglHasil(mData.get(posisi).getTglHasil());
                detHasil.setHomeTimHasil(mData.get(posisi).getHomeTimHasil());
                detHasil.setGolSkorerHomeHasil(mData.get(posisi).getGolSkorerHomeHasil());
                detHasil.setYellowCardHomeHasil(mData.get(posisi).getYellowCardHomeHasil());
                detHasil.setRedCardHomeHasil(mData.get(posisi).getRedCardHomeHasil());
                detHasil.setAwayTimhasil(mData.get(posisi).getAwayTimhasil());
                detHasil.setGolSkorerAwayhasil(mData.get(posisi).getGolSkorerAwayhasil());
                detHasil.setYellowCardAwayHasil(mData.get(posisi).getYellowCardAwayHasil());
                detHasil.setRedCardAwayHasil(mData.get(posisi).getRedCardAwayHasil());
                Intent pindahDetail = new Intent(context, DetailHasil.class); //memulai intent
                pindahDetail.putExtra("extra_soccer", detHasil); //data yang akan dikirim ke activity lain
                context.startActivity(pindahDetail); //pindah ke activity lain
            }

        });

        attribut.cvHasil.setTag(position);
        attribut.tvHomeHasil.setText(mData.get(position).getHomeTimHasil( ));
        attribut.tvAwayHasil.setText(mData.get(position).getAwayTimhasil( ));
        attribut.tvHasilTgl.setText(mData.get(position).getTglHasil( ));
        attribut.tvSkorHomeHasil.setText(mData.get(position).getHomeSkorHasil( ));
        attribut.tvSkorAwayHasil.setText(mData.get(position).getAwaySkorhasil( ));

        return convertView;
    }
}
