package com.example.com.example.services;

import com.example.NoteTypeData;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/11/16.
 */
public interface NoteTypeService {
    Optional<NoteTypeData> createNoteType(int tenantID, NoteTypeData data);
    Optional<NoteTypeData> getNoteType(int tenantID, int noteTypeID);
    Collection<NoteTypeData> getNoteTypes(int tenantID);
}
