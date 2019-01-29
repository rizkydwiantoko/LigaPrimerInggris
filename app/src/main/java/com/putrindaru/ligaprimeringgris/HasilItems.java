package com.putrindaru.ligaprimeringgris;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class HasilItems implements Parcelable {

    private String idHasil;
    private String vsHasil;
    private String tglHasil;
    private String homeTimHasil;
    private String awayTimhasil;
    private String homeSkorHasil;
    private String awaySkorhasil;
    private String redCardHomeHasil;
    private String yellowCardHomeHasil;
    private String redCardAwayHasil;
    private String yellowCardAwayHasil;
    private String golSkorerHomeHasil;
    private String golSkorerAwayhasil;
    private String gambarHasil;

    public HasilItems(JSONObject object){
        try {
            String idHasil = object.getString("idEvent");
            String vsHasil = object.getString("strEvent");
            String tglHasil = object.getString("dateEvent");
            String homeTimHasil = object.getString("strHomeTeam");
            String awayTimhasil = object.getString("strAwayTeam");
            String homeSkorHasil = object.getString("intHomeScore");
            String awaySkorhasil = object.getString("intAwayScore");
            String redCardHomeHasil = object.getString("strHomeRedCards");
            String yellowCardHomeHasil = object.getString("strHomeYellowCards");
            String redCardAwayHasil = object.getString("strAwayRedCards");
            String yellowCardAwayHasil = object.getString("strAwayYellowCards");
            String golSkorerHomeHasil = object.getString("strHomeGoalDetails");
            String golSkorerAwayhasil = object.getString("strAwayGoalDetails");
            String gambarHasil = object.getString("strThumb");


            this.idHasil = idHasil;
            this.vsHasil = vsHasil;
            this.tglHasil = tglHasil;
            this.homeTimHasil = homeTimHasil;
            this.awayTimhasil = awayTimhasil;
            this.homeSkorHasil = homeSkorHasil;
            this.awaySkorhasil = awaySkorhasil;
            this.redCardHomeHasil = redCardHomeHasil;
            this.yellowCardHomeHasil = yellowCardHomeHasil;
            this.redCardAwayHasil = redCardAwayHasil;
            this.yellowCardAwayHasil = yellowCardAwayHasil;
            this.golSkorerHomeHasil = golSkorerHomeHasil;
            this.golSkorerAwayhasil = golSkorerAwayhasil;
            this.gambarHasil = gambarHasil;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public HasilItems() {

    }
    public String getIdHasil() {
        return idHasil;
    }

    public void setIdHasil(String idHasil) {
        this.idHasil = idHasil;
    }

    public String getVsHasil() {
        return vsHasil;
    }

    public void setVsHasil(String vsHasil) {
        this.vsHasil = vsHasil;
    }

    public String getTglHasil() {
        return tglHasil;
    }

    public void setTglHasil(String tglHasil) {
        this.tglHasil = tglHasil;
    }

    public String getHomeTimHasil() {
        return homeTimHasil;
    }

    public void setHomeTimHasil(String homeTimHasil) {
        this.homeTimHasil = homeTimHasil;
    }

    public String getAwayTimhasil() {
        return awayTimhasil;
    }

    public void setAwayTimhasil(String awayTimhasil) {
        this.awayTimhasil = awayTimhasil;
    }

    public String getHomeSkorHasil() {
        return homeSkorHasil;
    }

    public void setHomeSkorHasil(String homeSkorHasil) {
        this.homeSkorHasil = homeSkorHasil;
    }

    public String getAwaySkorhasil() {
        return awaySkorhasil;
    }

    public void setAwaySkorhasil(String awaySkorhasil) {
        this.awaySkorhasil = awaySkorhasil;
    }

    public String getRedCardHomeHasil() {
        return redCardHomeHasil;
    }

    public void setRedCardHomeHasil(String redCardHomeHasil) {
        this.redCardHomeHasil = redCardHomeHasil;
    }

    public String getYellowCardHomeHasil() {
        return yellowCardHomeHasil;
    }

    public void setYellowCardHomeHasil(String yellowCardHomeHasil) {
        this.yellowCardHomeHasil = yellowCardHomeHasil;
    }

    public String getRedCardAwayHasil() {
        return redCardAwayHasil;
    }

    public void setRedCardAwayHasil(String redCardAwayHasil) {
        this.redCardAwayHasil = redCardAwayHasil;
    }

    public String getYellowCardAwayHasil() {
        return yellowCardAwayHasil;
    }

    public void setYellowCardAwayHasil(String yellowCardAwayHasil) {
        this.yellowCardAwayHasil = yellowCardAwayHasil;
    }

    public String getGolSkorerHomeHasil() {
        return golSkorerHomeHasil;
    }

    public void setGolSkorerHomeHasil(String golSkorerHomeHasil) {
        this.golSkorerHomeHasil = golSkorerHomeHasil;
    }

    public String getGolSkorerAwayhasil() {
        return golSkorerAwayhasil;
    }

    public void setGolSkorerAwayhasil(String golSkorerAwayhasil) {
        this.golSkorerAwayhasil = golSkorerAwayhasil;
    }

    public String getGambarHasil() {
        return gambarHasil;
    }

    public void setGambarHasil(String gambarHasil) {
        this.gambarHasil = gambarHasil;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idHasil);
        dest.writeString(this.vsHasil);
        dest.writeString(this.tglHasil);
        dest.writeString(this.homeTimHasil);
        dest.writeString(this.awayTimhasil);
        dest.writeString(this.homeSkorHasil);
        dest.writeString(this.awaySkorhasil);
        dest.writeString(this.redCardHomeHasil);
        dest.writeString(this.yellowCardHomeHasil);
        dest.writeString(this.redCardAwayHasil);
        dest.writeString(this.yellowCardAwayHasil);
        dest.writeString(this.golSkorerHomeHasil);
        dest.writeString(this.golSkorerAwayhasil);
        dest.writeString(this.gambarHasil);
    }

    protected HasilItems(Parcel in) {
        this.idHasil = in.readString( );
        this.vsHasil = in.readString( );
        this.tglHasil = in.readString( );
        this.homeTimHasil = in.readString( );
        this.awayTimhasil = in.readString( );
        this.homeSkorHasil = in.readString( );
        this.awaySkorhasil = in.readString( );
        this.redCardHomeHasil = in.readString( );
        this.yellowCardHomeHasil = in.readString( );
        this.redCardAwayHasil = in.readString( );
        this.yellowCardAwayHasil = in.readString( );
        this.golSkorerHomeHasil = in.readString( );
        this.golSkorerAwayhasil = in.readString( );
        this.gambarHasil = in.readString( );
    }

    public static final Parcelable.Creator<HasilItems> CREATOR = new Parcelable.Creator<HasilItems>( ) {
        @Override
        public HasilItems createFromParcel(Parcel source) {
            return new HasilItems(source);
        }

        @Override
        public HasilItems[] newArray(int size) {
            return new HasilItems[size];
        }
    };
}
