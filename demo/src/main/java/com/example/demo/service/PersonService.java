package com.example.demo.service;

import com.example.demo.model.Person;

import com.example.demo.dao.PersonDao;

import java.util.UUID;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    // Method to inserrt a new person
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
