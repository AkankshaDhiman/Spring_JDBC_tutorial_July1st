package com.example.springtutorial_jdbc.service;

import com.example.springtutorial_jdbc.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    public void addPerson(Person person) {
        System.out.println("Person added");
    }
}
