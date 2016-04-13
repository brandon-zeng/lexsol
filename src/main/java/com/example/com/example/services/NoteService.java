package com.example.com.example.services;

import com.example.NoteData;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/13/16.
 */
public interface NoteService {
    Optional<NoteData> addNote(int tenantID, NoteData data);
    Optional<NoteData> getNote(int tenantID, int noteID);
    Collection<NoteData> getNotes(int tenantID);
    void deleteNote(int tenantID, int noteID);
    Optional<NoteData> updateNote(int tenantID, NoteData data);
}
