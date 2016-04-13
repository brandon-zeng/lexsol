package com.example.com.example.services;

import com.example.NoteData;

import java.util.Optional;

/**
 * Created by vagrant on 4/13/16.
 */
public interface NoteService {
    Optional<NoteData> addNote(int tenantID, NoteData data);
}
