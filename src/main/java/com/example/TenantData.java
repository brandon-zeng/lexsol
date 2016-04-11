package com.example;

import com.example.model.tables.records.TenantRecord;

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

    public static TenantData from(TenantRecord record) {
        TenantData data = new TenantData();
        data.setId(record.getId());
        data.setPublic_key(record.getPublicKey());
        return data;
    }
}
