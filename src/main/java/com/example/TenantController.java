package com.example;

import com.example.com.example.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by vagrant on 4/11/16.
 */
@RestController
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @RequestMapping(value="/api/tenants", method = RequestMethod.GET)
    public Collection<TenantData> getTenants() {
        return  tenantService.getTenants();
    }

    @RequestMapping(value="/api/tenants", method = RequestMethod.POST)
    public ResponseEntity<TenantData> createTenant(@RequestBody TenantData tenant) {
        return new ResponseEntity<>(tenantService.createTenant(tenant).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/api/tenants/{id}", method = RequestMethod.GET)
    public ResponseEntity<TenantData> getTenant(@PathVariable int id) {
        return new ResponseEntity<>(tenantService.getTenant(id).get(), HttpStatus.OK);
    }
}
