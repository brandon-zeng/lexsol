package com.example.com.example.services;

import com.example.TenantData;
import com.example.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TenantRepository repository;

    @Override
    public Optional<TenantData> createTenant(TenantData newTenant) {
        return repository.addTenant(newTenant);
    }

    @Override
    public Collection<TenantData> getTenants() {
        return repository.getTenants();
    }

    @Override
    public Optional<TenantData> getTenant(int id) {
        return repository.getTenant(id);
    }
}
