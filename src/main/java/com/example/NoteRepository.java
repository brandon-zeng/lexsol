package com.example;

import com.example.model.tables.Note;
import com.example.model.tables.Notetype;
import com.example.model.tables.records.NoteRecord;
import com.example.model.tables.records.NotetypeRecord;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vagrant on 4/8/16.
 */
@Repository
public class NoteRepository {

    private final DSLContext jooq;

    @Autowired
    public NoteRepository(DSLContext jooq){
        this.jooq = jooq;
    }

    @Transactional(readOnly = true)
    public Collection<NoteData> getNotes(int tenantID){
        List<NoteRecord> queryResult = jooq.selectFrom(Note.NOTE).where(Note.NOTE.TENANT_ID.eq(tenantID)).fetchInto(NoteRecord.class);
        return queryResult.stream().map(NoteData::from).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<NoteData> getNote(int tenantID, int id){
        NoteRecord queryResult = jooq.selectFrom(Note.NOTE)
                .where(Note.NOTE.TENANT_ID.eq(tenantID), Note.NOTE.ID.eq(id))
                .fetchOne();
        return queryResult == null ? Optional.empty() : Optional.of(NoteData.from(queryResult));
    }

    @Transactional
    public NoteData addNote(int tenantID, NoteData data) {
        try {

            Record1<Integer> currentMaxRecord = jooq.select(Note.NOTE.ID.max()).from(Note.NOTE).fetchAny();
            int maxId = (currentMaxRecord.value1() != null && currentMaxRecord.value1() > 0) ? currentMaxRecord.value1() : 0;

            Note noteTbl = Note.NOTE;

            NoteRecord newRecord = jooq.insertInto(
                        noteTbl,
                        noteTbl.ID,
                        noteTbl.TENANT_ID,
                        noteTbl.NOTETYPE_ID,
                        noteTbl.PROPERTY_ID,
                        noteTbl.SITEVISIT_ID,
                        noteTbl.NOTEDATE,
                        noteTbl.SECONDARYDATE,
                        noteTbl.NOTE_,
                        noteTbl.CREATEDDATE,
                        noteTbl.CREATEDBY,
                        noteTbl.LASTMODIFIEDDATE,
                        noteTbl.SECONDARYDATECHANGEDBY_ID,
                        noteTbl.SECONDARYDATECHANGEDATE,
                        noteTbl.DEALISSUES,
                        noteTbl.DISCUSSIONPOINTS
                    )
                    .values(maxId + 1,
                            tenantID,
                            data.getNoteTypeData().getId(),
                            data.getPropertyId(),
                            data.getSiteVisitId(),
                            Timestamp.valueOf(data.getNoteDate()),
                            Timestamp.valueOf(data.getSecondaryDate()),
                            data.getNoteText(),
                            Timestamp.valueOf(data.getCreateDate()),
                            data.getCreatedById(),
                            Timestamp.valueOf(data.getLastModifiedDate()),
                            data.getSecondaryDateChangedById(),
                            null,
                            data.getDealIssues().toString(),
                            data.getDiscussionPoints().toString()
                    )
                    .returning(noteTbl.ID,
                            noteTbl.TENANT_ID,
                            noteTbl.NOTETYPE_ID,
                            noteTbl.PROPERTY_ID,
                            noteTbl.SITEVISIT_ID,
                            noteTbl.NOTEDATE,
                            noteTbl.SECONDARYDATE,
                            noteTbl.NOTE_,
                            noteTbl.CREATEDDATE,
                            noteTbl.CREATEDBY,
                            noteTbl.LASTMODIFIEDDATE,
                            noteTbl.SECONDARYDATECHANGEDBY_ID,
                            noteTbl.SECONDARYDATECHANGEDATE,
                            noteTbl.DEALISSUES,
                            noteTbl.DISCUSSIONPOINTS
                            )
                    .fetchOne();

            return NoteData.from(newRecord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
