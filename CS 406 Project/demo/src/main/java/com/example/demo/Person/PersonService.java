package com.example.demo.Person;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Annotations allow us to be more specific and where to find things
@Service
public class PersonService {

    public List<Person> getPerson() {
        return List.of(
                new Person(
                        1L, "Jane Smith", "Jane.Smith@techcorp.com",
                        LocalDate.of(1990, Month.JANUARY, 1),
                        21
                )
        );
    }
}
