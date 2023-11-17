package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.UUID;
import java.util.List;
import java.util.Optional;
// Contract for anyone that wants to implement this interface, the actions allowed
public interface PersonDao {

    //mocks a database usig a list
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        //generate the actual UUID itself
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);
}
