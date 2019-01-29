package com.putrindaru.ligaprimeringgris;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class KlubItems implements Parcelable {

    private String ivKlub;
    private String tvNamaKlub;
    private String tvMarkas;
    private String tvTahunBerdiri;
    private String tvPelatih;
    private String tvStadion;

    private String idKlub;
    private String klubAlias;
    private String klubKapasitas;
    private String klubWebsite;
    private String klubDeskripsi;
    private String klubBanner;
    private String gbrStadion;


    public KlubItems(JSONObject object) {
        try {
            String ivKlub = object.getString("strTeamBadge");
            String tvNamaKlub = object.getString("strTeam");
            String tvMarkas = object.getString("strStadiumLocation");
            String tvTahunBerdiri = object.getString("intFormedYear");
            String tvPelatih = object.getString("strManager");
            String tvStadion = object.getString("strStadium");

            String idKlub = object.getString("idTeam");
            String klubAlias = object.getString("strAlternate");
            String klubKapasitas = object.getString("intStadiumCapacity");
            String klubWebsite = object.getString("strWebsite");
            String klubDeskripsi = object.getString("strDescriptionEN");
            String klubBanner = object.getString("strTeamBanner");
            String gbrStadion = object.getString("strStadiumThumb");

            this.ivKlub = ivKlub;
            this.tvNamaKlub = tvNamaKlub;
            this.tvMarkas = tvMarkas;
            this.tvTahunBerdiri = tvTahunBerdiri;
            this.tvPelatih = tvPelatih;
            this.tvStadion = tvStadion;

            this.idKlub = idKlub;
            this.klubAlias = klubAlias;
            this.klubKapasitas = klubKapasitas;
            this.klubWebsite = klubWebsite;
            this.klubDeskripsi = klubDeskripsi;
            this.klubBanner = klubBanner;
            this.gbrStadion = gbrStadion;

        } catch (JSONException e) {
            e.printStackTrace( );
        }
    }

    public KlubItems() {

    }

    public String getIvKlub() {
        return ivKlub;
    }

    public void setIvKlub(String ivKlub) {
        this.ivKlub = ivKlub;
    }

    public String getTvNamaKlub() {
        return tvNamaKlub;
    }

    public void setTvNamaKlub(String tvNamaKlub) {
        this.tvNamaKlub = tvNamaKlub;
    }

    public String getTvMarkas() {
        return tvMarkas;
    }

    public void setTvMarkas(String tvMarkas) {
        this.tvMarkas = tvMarkas;
    }

    public String getTvTahunBerdiri() {
        return tvTahunBerdiri;
    }

    public String getGbrStadion() {
        return gbrStadion;
    }

    public void setGbrStadion(String gbrStadion) {
        this.gbrStadion = gbrStadion;
    }

    public void setTvTahunBerdiri(String tvTahunBerdiri) {
        this.tvTahunBerdiri = tvTahunBerdiri;
    }

    public String getTvPelatih() {
        return tvPelatih;
    }

    public void setTvPelatih(String tvPelatih) {
        this.tvPelatih = tvPelatih;
    }

    public String getTvStadion() {
        return tvStadion;
    }

    public void setTvStadion(String tvStadion) {
        this.tvStadion = tvStadion;
    }

    public String getKlubAlias() {
        return klubAlias;
    }

    public void setKlubAlias(String klubAlias) {
        this.klubAlias = klubAlias;
    }

    public String getKlubKapasitas() {
        return klubKapasitas;
    }

    public void setKlubKapasitas(String klubKapasitas) {
        this.klubKapasitas = klubKapasitas;
    }

    public String getKlubWebsite() {
        return klubWebsite;
    }

    public void setKlubWebsite(String klubWebsite) {
        this.klubWebsite = klubWebsite;
    }

    public String getKlubDeskripsi() {
        return klubDeskripsi;
    }

    public void setKlubDeskripsi(String klubDeskripsi) {
        this.klubDeskripsi = klubDeskripsi;
    }

    public String getKlubBanner() {
        return klubBanner;
    }

    public void setKlubBanner(String klubBanner) {
        this.klubBanner = klubBanner;
    }

    public String getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(String idKlub) {
        this.idKlub = idKlub;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ivKlub);
        dest.writeString(this.tvNamaKlub);
        dest.writeString(this.tvMarkas);
        dest.writeString(this.tvTahunBerdiri);
        dest.writeString(this.tvPelatih);
        dest.writeString(this.tvStadion);
        dest.writeString(this.idKlub);
        dest.writeString(this.klubAlias);
        dest.writeString(this.klubKapasitas);
        dest.writeString(this.klubWebsite);
        dest.writeString(this.klubDeskripsi);
        dest.writeString(this.klubBanner);
        dest.writeString(this.gbrStadion);
    }

    protected KlubItems(Parcel in) {
        this.ivKlub = in.readString( );
        this.tvNamaKlub = in.readString( );
        this.tvMarkas = in.readString( );
        this.tvTahunBerdiri = in.readString( );
        this.tvPelatih = in.readString( );
        this.tvStadion = in.readString( );
        this.idKlub = in.readString( );
        this.klubAlias = in.readString( );
        this.klubKapasitas = in.readString( );
        this.klubWebsite = in.readString( );
        this.klubDeskripsi = in.readString( );
        this.klubBanner = in.readString( );
        this.gbrStadion = in.readString( );
    }

    public static final Creator<KlubItems> CREATOR = new Creator<KlubItems>( ) {
        @Override
        public KlubItems createFromParcel(Parcel source) {
            return new KlubItems(source);
        }

        @Override
        public KlubItems[] newArray(int size) {
            return new KlubItems[size];
        }
    };
}