package com.example;

import com.example.model.tables.Note;
import com.example.model.tables.Notetype;
import com.example.model.tables.Tenant;
import com.example.model.tables.records.NoteRecord;
import com.example.model.tables.records.NotetypeRecord;
import com.example.model.tables.records.TenantRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<NoteTypeData> createNoteType(int tenantID, NoteTypeData data) {
        Record1<Integer> currentMaxRecord = jooq.select(Notetype.NOTETYPE.ID.max()).from(Notetype.NOTETYPE).fetchAny();
        int maxId = (currentMaxRecord.value1() != null && currentMaxRecord.value1() > 0) ? currentMaxRecord.value1() : 0;

        Notetype noteTypeTbl = Notetype.NOTETYPE;

        NotetypeRecord r = jooq
                .insertInto(noteTypeTbl,
                            noteTypeTbl.ID,
                            noteTypeTbl.NAME,
                            noteTypeTbl.TENANT_ID,
                            noteTypeTbl.SECONDARYDATE,
                            noteTypeTbl.SITEVISIT_ID,
                            noteTypeTbl.SHOWDEALISSUES,
                            noteTypeTbl.DELETEPERMITTEDINTERVAL,
                            noteTypeTbl.DISCUSSIONTOPICS
                            )
                .values(maxId + 1,
                        data.getName(),
                        tenantID,
                        data.getSecondarydate(),
                        data.getSitevisit(),
                        data.getShowDealIssues(),
                        data.getDeletePermittedInterval(),
                        data.getDiscussionTopics().toString()
                        )
                 .returning(noteTypeTbl.ID,
                            noteTypeTbl.NAME,
                            noteTypeTbl.TENANT_ID,
                            noteTypeTbl.SECONDARYDATE,
                            noteTypeTbl.SITEVISIT_ID,
                            noteTypeTbl.SHOWDEALISSUES,
                            noteTypeTbl.DELETEPERMITTEDINTERVAL,
                            noteTypeTbl.DISCUSSIONTOPICS)
                .fetchOne();

        return  r == null ? Optional.empty() : Optional.of(NoteTypeData.from(r));
    }

    public Optional<NoteTypeData> getNoteType(int tenantID, int noteTypeID) {
        NotetypeRecord queryResult = jooq.selectFrom(Notetype.NOTETYPE)
                .where(Notetype.NOTETYPE.TENANT_ID.eq(tenantID), Notetype.NOTETYPE.ID.eq(noteTypeID))
                .fetchOne();

        return queryResult == null ? Optional.empty() : Optional.of(NoteTypeData.from(queryResult));
    }

    public Collection<NoteTypeData> getNoteTypes(int tenantID) {
        List<NotetypeRecord> result = jooq.selectFrom(Notetype.NOTETYPE)
                .where(Notetype.NOTETYPE.TENANT_ID.eq(tenantID))
                .fetchInto(NotetypeRecord.class);
        return result.stream().map(NoteTypeData::from).collect(Collectors.toList());
    }

}
