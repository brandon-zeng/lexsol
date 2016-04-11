package com.example;

import com.example.model.tables.Note;
import com.example.model.tables.records.NoteRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public Collection<NoteData> getNotes(){
        List<NoteRecord> queryResult = jooq.selectFrom(Note.NOTE).fetchInto(NoteRecord.class);
        return queryResult.stream().map(NoteData::from).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<NoteData> getNote(int id){
        NoteRecord queryResult = jooq.fetchAny(Note.NOTE, Note.NOTE.ID.eq(id));
        return queryResult == null ? Optional.empty() : Optional.of(NoteData.from(queryResult));
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
