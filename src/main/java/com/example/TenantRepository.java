package com.example;

import com.example.model.tables.Tenant;
import com.example.model.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by vagrant on 4/11/16.
 */
@Repository
public class TenantRepository {
    private final DSLContext jooq;

    @Autowired
    public TenantRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    public TenantData addTenant(TenantData newTenant) {
        Record1<Integer> t = jooq.select(Tenant.TENANT.ID.max()).from(Tenant.TENANT).fetchAny();
        int maxId = t.size() > 1 ? t.value1() : 0;
        TenantRecord r = jooq
                            .insertInto(Tenant.TENANT, Tenant.TENANT.ID, Tenant.TENANT.PUBLIC_KEY)
                            .values(maxId + 1, newTenant.getPublic_key())
                            .returning(Tenant.TENANT.ID, Tenant.TENANT.PUBLIC_KEY)
                            .fetchOne();

        return TenantData.from(r);
    }
}
