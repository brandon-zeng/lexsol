package com.example;

import com.example.com.example.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<TenantData>(tenantService.createTenant(tenant).get(), HttpStatus.OK);
    }


}
