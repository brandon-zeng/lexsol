package com.example;

import com.example.com.example.services.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by vagrant on 4/11/16.
 */
@RestController
public class NoteTypeController {

    @Autowired
    NoteTypeService service;

    @RequestMapping(value = "/api/noteTypes", method = RequestMethod.POST)
    public ResponseEntity<NoteTypeData> addNoteType(@RequestBody NoteTypeData data)  {
        return new ResponseEntity<>(service.createNoteType(data).get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/noteTypes", method = RequestMethod.GET)
    public Collection<NoteTypeData> getNoteTypes()  {
        return service.getNoteTypes();
    }

    @RequestMapping(value = "/api/noteTypes/{id}", method = RequestMethod.GET)
    public ResponseEntity<NoteTypeData> getNoteType(@PathVariable int id) {
        return new ResponseEntity<>(service.getNoteType(id).get(), HttpStatus.OK);
    }
}
