package com.example;

import com.example.model.tables.Note;
import com.example.model.tables.records.NoteRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public List<NoteData> getNotes(){
        List<NoteData> results = new ArrayList<NoteData>();
        List<com.example.model.tables.records.NoteRecord> queryResult = jooq.selectFrom(Note.NOTE).fetchInto(NoteRecord.class);

        for(NoteRecord record : queryResult) {
            results.add(NoteData.from(record));
        }
        return results;
    }

    @Transactional(readOnly = true)
    public NoteData getNote(int id){
        NoteRecord queryResult = jooq.fetchAny(Note.NOTE, Note.NOTE.ID.eq(id));

        if (queryResult != null) {
            return NoteData.from(queryResult);
        }
        return null;
    }

    @Transactional
    public NoteData addNote(NoteData data) {
        try {

//            int maxId = jooq.select(Note.NOTE.ID.max()).from(Note.NOTE).fetchAny().value1();
//
//            NoteRecord newRecord = jooq.insertInto(Note.NOTE, Note.NOTE.ID, Note.NOTE.NAME, Note.NOTE.C_ID)
//                    .values(maxId + 1, data.getName(), 1)
//                    .returning(Note.NOTE.ID, Note.NOTE.NAME)
//                    .fetchOne();
//
//            return NoteData.from(newRecord);
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
