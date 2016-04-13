package com.example.com.example.services;

import com.example.NoteData;
import com.example.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/13/16.
 */
@Component
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository repository;

    @Override
    public Optional<NoteData> addNote(int tenantID, NoteData data) {
        data.setNoteDate(LocalDateTime.now());
        data.setSecondaryDate(LocalDateTime.now());
        data.setCreateDate(LocalDateTime.now());
        data.setLastModifiedDate(LocalDateTime.now());
        return Optional.of(repository.addNote(tenantID, data));
    }

    @Override
    public Optional<NoteData> getNote(int tenantID, int noteID) {
        return repository.getNote(tenantID, noteID);
    }

    @Override
    public Collection<NoteData> getNotes(int tenantID) {
        return repository.getNotes(tenantID);
    }

    @Override
    public void deleteNote(int tenantID, int noteID) {
        repository.deleteNote(tenantID, noteID);
    }

    @Override
    public Optional<NoteData> updateNote(int tenantID, NoteData data) {
        return repository.updateNote(tenantID, data);
    }
}
