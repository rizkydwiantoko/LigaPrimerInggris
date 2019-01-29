package com.putrindaru.ligaprimeringgris;

import org.json.JSONException;
import org.json.JSONObject;

public class HomeItems {

    private String ivHomePoster;
    private String tvHomeJenisLiga;
    private String tvHomeNamaLiga;
    private String tvHomeNegaraLiga;
    private String tvHomeWebLiga;
    private String tvHomeDeskLiga;
    private String ivHomeBanner;

        public HomeItems(JSONObject object) {
        try {
            String ivHomePoster = object.getString("strBadge");
            String ivHomeBanner = object.getString("strBanner");
            String tvHomeJenisLiga = object.getString("strSport");
            String tvHomeNamaLiga = object.getString("strLeague");
            String tvHomeNegaraLiga = object.getString("strCountry");
            String tvHomeWebLiga = object.getString("strWebsite");
            String tvHomeDeskLiga = object.getString("strDescriptionEN");

            this.ivHomeBanner = ivHomeBanner;
            this.ivHomePoster = ivHomePoster;
            this.tvHomeJenisLiga = tvHomeJenisLiga;
            this.tvHomeNamaLiga = tvHomeNamaLiga;
            this.tvHomeNegaraLiga = tvHomeNegaraLiga;
            this.tvHomeWebLiga = tvHomeWebLiga;
            this.tvHomeDeskLiga = tvHomeDeskLiga;

        } catch (JSONException e) {
            e.printStackTrace( );
        }
    }

    public String getIvHomeBanner() {
        return ivHomeBanner;
    }

    public void setIvHomeBanner(String ivHomeBanner) {
        this.ivHomeBanner = ivHomeBanner;
    }

    public String getIvHomePoster() {
        return ivHomePoster;
    }

    public void setIvHomePoster(String ivHomePoster) {
        this.ivHomePoster = ivHomePoster;
    }

    public String getTvHomeJenisLiga() {
        return tvHomeJenisLiga;
    }

    public void setTvHomeJenisLiga(String tvHomeJenisLiga) {
        this.tvHomeJenisLiga = tvHomeJenisLiga;
    }

    public String getTvHomeNamaLiga() {
        return tvHomeNamaLiga;
    }

    public void setTvHomeNamaLiga(String tvHomeNamaLiga) {
        this.tvHomeNamaLiga = tvHomeNamaLiga;
    }

    public String getTvHomeNegaraLiga() {
        return tvHomeNegaraLiga;
    }

    public void setTvHomeNegaraLiga(String tvHomeNegaraLiga) {
        this.tvHomeNegaraLiga = tvHomeNegaraLiga;
    }

    public String getTvHomeWebLiga() {
        return tvHomeWebLiga;
    }

    public void setTvHomeWebLiga(String tvHomeWebLiga) {
        this.tvHomeWebLiga = tvHomeWebLiga;
    }

    public String getTvHomeDeskLiga() {
        return tvHomeDeskLiga;
    }

    public void setTvHomeDeskLiga(String tvHomeDeskLiga) {
        this.tvHomeDeskLiga = tvHomeDeskLiga;
    }
}