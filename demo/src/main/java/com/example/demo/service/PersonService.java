package com.example.demo.service;

import com.example.demo.model.Person;

import com.example.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao) {

        this.personDao = personDao;
    }
    // Method to inserrt a new person, to randomly generate a person
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }
}
