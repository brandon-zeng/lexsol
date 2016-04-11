package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 4/8/16.
 */
@RestController
public class NoteController {

    @Autowired
    private NoteRepository repository;

    @RequestMapping(value = "/api/notes", method = RequestMethod.GET)
    public List<NoteData> getNotes() {
        return this.repository.getNotes();
    }

    @RequestMapping(value = "/api/notes/{noteId}", method = RequestMethod.GET)
    public NoteData getNote(@PathVariable int noteId) {
        return this.repository.getNote(noteId);
    }

    @RequestMapping(value = "/api/notes", method = RequestMethod.POST)
    public ResponseEntity<NoteData> addNote(@RequestBody NoteData input) {
        this.validateSite();
        NoteData newNote = this.repository.addNote(input);
        return new ResponseEntity<NoteData>(newNote, HttpStatus.OK);
    }

    private void validateSite() {

    }
}
