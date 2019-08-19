package com.crederablogtutorial.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService personService) {
        this.service = personService;
    }

    @GetMapping(path="/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonEntity> getAll(){
        List<PersonEntity> response = service.getAll();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(path="/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonEntity> addPerson(@RequestBody PersonEntity p) {
        service.addPerson(p);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

