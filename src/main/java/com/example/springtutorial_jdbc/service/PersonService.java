package com.example.springtutorial_jdbc.service;

import com.example.springtutorial_jdbc.model.Person;
import com.example.springtutorial_jdbc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository repository= new PersonRepository();


    public void addPerson(Person person) {
        repository.save(person);
        System.out.println("person added");
    }
    public PersonRepository getRepository() {
        return repository;
    }
    @Autowired
    public void setRepository(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> showAllPersons() {
        return repository.findAll();
    }
}
