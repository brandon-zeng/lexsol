package com.example;

/**
 * Created by vagrant on 4/8/16.
 */
public class SiteData {
    private int id;
    private String public_key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public static SiteData from(int id){
        SiteData data = new SiteData();
        data.setId(id);
        return data;
    }
}
