package com.putrindaru.ligaprimeringgris;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class PemainItems implements Parcelable {

    private String ivPotoPemain;
    private String tvNamaPemain;
    private String tvNegaraPemain;
    private String tvTTLPemain;
    private String tvTBPemain;
    private String tvPosisiPemain;
    private String beratPemain;
    private String tpLahirPemain;

    public PemainItems(JSONObject object) {
        try {
            String ivPotoPemain = object.getString("strCutout");
            String tvNamaPemain = object.getString("strPlayer");
            String tvNegaraPemain = object.getString("strNationality");
            String tvTTLPemain = object.getString("dateBorn");
            String tvTBPemain = object.getString("strHeight");
            String tvPosisiPemain = object.getString("strPosition");
            String beratPemain = object.getString("strWeight");
            String tpLahirPemain = object.getString("strBirthLocation");

            this.ivPotoPemain = ivPotoPemain;
            this.tvNamaPemain = tvNamaPemain;
            this.tvNegaraPemain = tvNegaraPemain;
            this.tvTTLPemain = tvTTLPemain;
            this.tvTBPemain = tvTBPemain;
            this.tvPosisiPemain = tvPosisiPemain;
            this.beratPemain = beratPemain;
            this.tpLahirPemain = tpLahirPemain;

        } catch (JSONException e) {
            e.printStackTrace( );
        }
    }

    public String getIvPotoPemain() {
        return ivPotoPemain;
    }

    public void setIvPotoPemain(String ivPotoPemain) {
        this.ivPotoPemain = ivPotoPemain;
    }

    public String getTvNamaPemain() {
        return tvNamaPemain;
    }

    public void setTvNamaPemain(String tvNamaPemain) {
        this.tvNamaPemain = tvNamaPemain;
    }

    public String getTvNegaraPemain() {
        return tvNegaraPemain;
    }

    public void setTvNegaraPemain(String tvNegaraPemain) {
        this.tvNegaraPemain = tvNegaraPemain;
    }

    public String getTvTTLPemain() {
        return tvTTLPemain;
    }

    public void setTvTTLPemain(String tvTTLPemain) {
        this.tvTTLPemain = tvTTLPemain;
    }

    public String getTvTBPemain() {
        return tvTBPemain;
    }

    public void setTvTBPemain(String tvTBPemain) {
        this.tvTBPemain = tvTBPemain;
    }

    public String getTvPosisiPemain() {
        return tvPosisiPemain;
    }

    public void setTvPosisiPemain(String tvPosisiPemain) {
        this.tvPosisiPemain = tvPosisiPemain;
    }

    public String getBeratPemain() {
        return beratPemain;
    }

    public void setBeratPemain(String beratPemain) {
        this.beratPemain = beratPemain;
    }

    public String getTpLahirPemain() {
        return tpLahirPemain;
    }

    public void setTpLahirPemain(String tpLahirPemain) {
        this.tpLahirPemain = tpLahirPemain;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ivPotoPemain);
        dest.writeString(this.tvNamaPemain);
        dest.writeString(this.tvNegaraPemain);
        dest.writeString(this.tvTTLPemain);
        dest.writeString(this.tvTBPemain);
        dest.writeString(this.tvPosisiPemain);
        dest.writeString(this.beratPemain);
        dest.writeString(this.tpLahirPemain);
    }

    protected PemainItems(Parcel in) {
        this.ivPotoPemain = in.readString( );
        this.tvNamaPemain = in.readString( );
        this.tvNegaraPemain = in.readString( );
        this.tvTTLPemain = in.readString( );
        this.tvTBPemain = in.readString( );
        this.tvPosisiPemain = in.readString( );
        this.beratPemain = in.readString( );
        this.tpLahirPemain = in.readString( );
    }

    public static final Parcelable.Creator<PemainItems> CREATOR = new Parcelable.Creator<PemainItems>( ) {
        @Override
        public PemainItems createFromParcel(Parcel source) {
            return new PemainItems(source);
        }

        @Override
        public PemainItems[] newArray(int size) {
            return new PemainItems[size];
        }
    };
}