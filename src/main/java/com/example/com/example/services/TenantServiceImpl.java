package com.example.com.example.services;

import com.example.TenantData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by vagrant on 4/11/16.
 */
@Component
class TenantServiceImpl implements TenantService {

    @Override
    public Optional<TenantData> createTenant(TenantData newTenant) {
        return null;
    }

    @Override
    public Collection<TenantData> getTenants() {
        return new ArrayList<>();
    }
}
