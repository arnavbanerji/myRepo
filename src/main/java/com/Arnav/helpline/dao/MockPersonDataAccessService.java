package com.Arnav.helpline.dao;

import com.Arnav.helpline.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//act this class as a database
@Repository("mockDao")
public class MockPersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1; //insertion would always work so let's hardcode this as 1.
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(!personMaybe.isPresent()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person updatedPerson) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToDelete = DB.indexOf(person);
                    if(indexOfPersonToDelete >= 0) {
                        DB.set(indexOfPersonToDelete, new Person(id, updatedPerson.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
