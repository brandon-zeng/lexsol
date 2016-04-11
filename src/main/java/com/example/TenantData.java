package com.example;

/**
 * Created by vagrant on 4/8/16.
 */
public class TenantData {
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

    public static TenantData from(int id){
        TenantData data = new TenantData();
        data.setId(id);
        return data;
    }
}
