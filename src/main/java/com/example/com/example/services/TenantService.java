package com.example.com.example.services;

import com.example.TenantData;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/11/16.
 */
public interface TenantService {

    Optional<TenantData> createTenant(TenantData newTenant);
    Collection<TenantData> getTenants();
}
