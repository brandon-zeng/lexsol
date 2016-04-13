package com.example;

import com.example.model.tables.Note;
import com.example.model.tables.Notetype;
import com.example.model.tables.records.NoteRecord;
import com.example.model.tables.records.NotetypeRecord;
import org.apache.tomcat.jni.Local;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public void deleteNote(int tenantID, int noteID) {
        NoteRecord r = jooq.fetchOne(Note.NOTE, Note.NOTE.ID.eq(noteID));
        r.delete();
    }

    public Optional<NoteData> updateNote(int tenantID, NoteData data) {
        /*
         *{"timestamp":"2016-04-13T16:08:33.285+0000",
         * "status":500,"error":"Internal Server Error",
         * "exception":"org.springframework.jdbc.BadSqlGrammarException","message":"jOOQ;
         * bad SQL grammar [update \"public\".\"note\" set \"public\".\"note\".\"note\" = ?, \"public\".\"note\".\"lastmodifieddate\" = ? where \"public\".\"note\".\"id\" = ?]; nested exception is org.postgresql.util.PSQLException: ERROR: column \"public\" of relation \"note\" does not exist\n  Position: 28","path":"/api/tenants/1/notes/1"}
         */
//        NoteRecord r = jooq.fetchOne(Note.NOTE, Note.NOTE.ID.eq(data.getId()));
//
//        r.setNote(data.getNoteText());
//        r.setLastmodifieddate(Timestamp.valueOf(LocalDateTime.now()));
//        r.store();

        jooq.update(Note.NOTE).set(Note.NOTE.LASTMODIFIEDDATE, Timestamp.valueOf(LocalDateTime.now()))
                              .where(Note.NOTE.ID.equals(data.getId())).execute();

        NoteRecord r = jooq.fetchOne(Note.NOTE, Note.NOTE.ID.eq(data.getId()));
        r.refresh();
        return Optional.of(NoteData.from(r));
    }
}
