package com.example.com.example.services;

import com.example.NoteTypeData;
import com.example.NoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by vagrant on 4/11/16.
 */
@Component
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    private NoteTypeRepository repo;

    @Override
    public Optional<NoteTypeData> createNoteType(int tenantID, NoteTypeData data) {
        return repo.createNoteType(tenantID, data);
    }

    @Override
    public Optional<NoteTypeData> getNoteType(int tenantID, int noteTypeID) {
        return repo.getNoteType(tenantID, noteTypeID);
    }

    @Override
    public Collection<NoteTypeData> getNoteTypes(int tenantID) {
        return repo.getNoteTypes(tenantID);
    }
}
