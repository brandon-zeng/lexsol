package com.example;

import com.example.com.example.services.NoteService;
import com.example.com.example.services.NoteTypeService;
import com.example.com.example.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by vagrant on 4/11/16.
 */
@RestController
@RequestMapping(value="/api/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public Collection<TenantData> getTenants() {
        return  tenantService.getTenants();
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<TenantData> createTenant(@RequestBody TenantData tenant) {
        return new ResponseEntity<>(tenantService.createTenant(tenant).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<TenantData> getTenant(@PathVariable int id) {
        return new ResponseEntity<>(tenantService.getTenant(id).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/noteTypes", method = RequestMethod.GET)
    public Collection<NoteTypeData> getNoteTypes(@PathVariable int id) {
        return noteTypeService.getNoteTypes(id);
    }

    @RequestMapping(value="/{id}/noteTypes", method = RequestMethod.POST)
    public ResponseEntity<NoteTypeData> addNoteTypes(@PathVariable int id, @RequestBody NoteTypeData data) {
        return new ResponseEntity<>(noteTypeService.createNoteType(id, data).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{tenantID}/noteTypes/{noteTypeID}", method = RequestMethod.GET)
    public ResponseEntity<NoteTypeData> getNoteType(@PathVariable int tenantID, @PathVariable int noteTypeID) {
        return new ResponseEntity<>(noteTypeService.getNoteType(tenantID, noteTypeID).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{tenantID}/notes", method = RequestMethod.POST)
    public ResponseEntity<NoteData> addNote(@PathVariable int tenantID, @RequestBody NoteData data) {
        return new ResponseEntity<>(noteService.addNote(tenantID, data).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{tenantID}/notes/{noteID}", method = RequestMethod.GET)
    public ResponseEntity<NoteData> getNote(@PathVariable int tenantID, @PathVariable int noteID) {
        return new ResponseEntity<>(noteService.getNote(tenantID, noteID).get(), HttpStatus.OK);
    }

    @RequestMapping(value="/{tenantID}/notes", method = RequestMethod.GET)
    public Collection<NoteData> getNotes(@PathVariable int tenantID) {
        return noteService.getNotes(tenantID);
    }

    @RequestMapping(value = "/{tenantID}/notes/{noteID}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable int tenantID, @PathVariable int noteID) {
        noteService.deleteNote(tenantID, noteID);
    }

    @RequestMapping(value = "/{tenantID}/notes/{noteID}", method = RequestMethod.PUT)
    public ResponseEntity<NoteData> updateNote(@PathVariable int tenantID, @PathVariable int noteID, @RequestBody NoteData data) {
        return new ResponseEntity<>(noteService.updateNote(tenantID, data).get(), HttpStatus.OK);
    }
}
