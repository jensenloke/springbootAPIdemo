package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.UUID;

public interface PersonDao {
    //insert person with given ID
    int insertPerson(UUID id,Person person);

    //randomly generate ID
    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
}
