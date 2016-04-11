package com.example;

import com.example.model.tables.Notetype;
import com.example.model.tables.Tenant;
import com.example.model.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/11/16.
 */
@Repository
public class NoteTypeRepository {
    @Autowired
    private DSLContext jooq;

//    @Autowired
//    public NoteTypeRepository(DSLContext jooq) {
//        this.jooq = jooq;
//    }

    public Optional<NoteTypeData> createNoteType(NoteTypeData data) {
        return null;
    }

    public Optional<NoteTypeData> getNoteType(int id) {
        return null;
    }

    public Collection<NoteTypeData> getNoteTypes() {
        return null;
    }

}
