package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.UUID;
// Contract for anyone that wants to implement this interface
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
}
