package com.putrindaru.ligaprimeringgris;

import org.json.JSONException;
import org.json.JSONObject;

public class KlasemenItems {

    private String namaTim;
    private String idTim;
    private int jmlTanding;
    private int menang;
    private int seri;
    private int kalah;
    private int golM;
    private int golK;
    private int poin;

    public KlasemenItems(JSONObject object){
        try {
            String namaTim = object.getString("name");
            String idTim = object.getString("teamid");
            int jmlTanding = object.getInt("played");
            int menang = object.getInt("win");
            int seri = object.getInt("draw");
            int kalah = object.getInt("loss");
            int golM = object.getInt("goalsfor");
            int golK = object.getInt("goalsagainst");
            int poin = object.getInt("total");

            this.namaTim = namaTim;
            this.idTim = idTim;
            this.jmlTanding = jmlTanding;
            this.menang = menang;
            this.seri  = seri;
            this.kalah = kalah;
            this.golM = golM;
            this.golK = golK;
            this.poin = poin;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public KlasemenItems() {

    }

    public String getNamaTim() {
        return namaTim;
    }
    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }
    public String getIdTim() {
        return idTim;
    }
    public void setIdTim(String idTim) {
        this.namaTim = idTim;
    }
    public int getJmlTanding() {return jmlTanding; }
    public void setJmlTanding (int jmlTanding) {
        this.jmlTanding = jmlTanding;
    }
    public int getMenang() {
        return menang;
    }
    public void setMenang(int menang) {
        this.menang = menang;
    }
    public int getSeri() {return seri; }
    public void setSeri (int seri) {
        this.seri = seri;
    }
    public int getKalah() {
        return kalah;
    }
    public void setKalah(int kalah) {
        this.kalah = kalah;
    }
    public int getGolM() {return golM; }
    public void setGolM (int golM) {
        this.golM = golM;
    }
    public int getGolK() {return golK; }
    public void setGolK (int golK) {
        this.golK = golK;
    }
    public int getPoin() {return poin; }
    public void setPoin (int poin) {
        this.poin = poin;
    }

}
