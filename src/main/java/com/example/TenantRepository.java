package com.example;

import com.example.model.tables.Tenant;
import com.example.model.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Transactional
    public Collection<TenantData> getTenants() {
        List<TenantRecord> result = jooq.selectFrom(Tenant.TENANT).fetchInto(TenantRecord.class);
        return result.stream().map(TenantData::from).collect(Collectors.toList());
    }

    @Transactional
    public Optional<TenantData> addTenant(TenantData newTenant) {
        Record1<Integer> currentMaxRecord = jooq.select(Tenant.TENANT.ID.max()).from(Tenant.TENANT).fetchAny();
        int maxId = (currentMaxRecord.value1() != null && currentMaxRecord.value1() > 0) ? currentMaxRecord.value1() : 0;
        TenantRecord r = jooq
                            .insertInto(Tenant.TENANT, Tenant.TENANT.ID, Tenant.TENANT.PUBLIC_KEY)
                            .values(maxId + 1, newTenant.getPublic_key())
                            .returning(Tenant.TENANT.ID, Tenant.TENANT.PUBLIC_KEY)
                            .fetchOne();

        return  r == null ? Optional.empty() : Optional.of(TenantData.from(r));
    }

    @Transactional
    public Optional<TenantData> getTenant(int id) {
        TenantRecord r = jooq.fetchAny(Tenant.TENANT, Tenant.TENANT.ID.eq(id));
        return r == null ? Optional.empty() : Optional.of(TenantData.from(r));
    }
}
