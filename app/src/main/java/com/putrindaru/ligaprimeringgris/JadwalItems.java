package com.putrindaru.ligaprimeringgris;

import org.json.JSONException;
import org.json.JSONObject;

public class JadwalItems {

    private String noId;
    private String timVersus;
    private String tglVersus;
    private String jamVersus;
    private String homeVersus;
    private String awayVersus;

    public JadwalItems(JSONObject object){
        try {
            String noId = object.getString("idEvent");
            String timVersus = object.getString("strEvent");
            String tglVersus = object.getString("dateEvent");
            String jamVersus = object.getString("strTime");
            String homeVersus = object.getString("strHomeTeam");
            String awayVersus = object.getString("strAwayTeam");


            this.noId = noId;
            this.timVersus = timVersus;
            this.tglVersus = tglVersus;
            this.jamVersus = jamVersus;
            this.homeVersus = homeVersus;
            this.awayVersus = awayVersus;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JadwalItems() {

    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public String getTimVersus() {
        return timVersus;
    }

    public void setTimVersus(String timVersus) {
        this.timVersus = timVersus;
    }

    public String getTglVersus() {
        return tglVersus;
    }

    public void setTglVersus(String tglVersus) {
        this.tglVersus = tglVersus;
    }

    public String getJamVersus() {
        return jamVersus;
    }

    public void setJamVersus(String jamVersus) {
        this.jamVersus = jamVersus;
    }

    public String getHomeVersus() {
        return homeVersus;
    }

    public void setHomeVersus(String homeVersus) {
        this.homeVersus = homeVersus;
    }

    public String getAwayVersus() {
        return awayVersus;
    }

    public void setAwayVersus(String awayVersus) {
        this.awayVersus = awayVersus;
    }
}
