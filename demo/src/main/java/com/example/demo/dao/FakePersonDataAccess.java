package com.example.demo.dao;

import com.example.demo.model.Person;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class FakePersonDataAccess implements PersonDao {
    // so in order to add a person we just need to add a person to the DB database from list
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        // to add a person add to the database
        DB.add(new Person(id, person.getName()));
        // return 1 so that we know the insertion always works
        return 1;
    }
}
