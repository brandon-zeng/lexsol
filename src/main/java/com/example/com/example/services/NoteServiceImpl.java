package com.example.com.example.services;

import com.example.NoteData;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by vagrant on 4/13/16.
 */
@Component
public class NoteServiceImpl implements NoteService {
    @Override
    public Optional<NoteData> addNote(int tenantID, NoteData data) {
        return null;
    }
}
