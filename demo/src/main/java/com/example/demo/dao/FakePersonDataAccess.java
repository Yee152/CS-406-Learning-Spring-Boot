package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
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
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personOp = selectPersonById(id);
        if (personOp.isEmpty()) {
            return 0;
        }
        DB.remove(personOp.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getID().equals(id))
                .findFirst();

    }
}
