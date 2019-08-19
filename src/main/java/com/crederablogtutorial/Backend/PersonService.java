package com.crederablogtutorial.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;
    @Autowired
    public PersonService(PersonRepository personRepository)
    {
        this.repository = personRepository;
    }

    public List<PersonEntity> getAll(){
        return repository.findAll();
    }

    public void addPerson(PersonEntity p) { repository.save(p); }
}
