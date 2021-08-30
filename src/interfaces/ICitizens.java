package interfaces;

import models.Person;

import java.time.LocalDate;

public interface ICitizens {
    boolean add(Person person);
    boolean remove(int id);
    Person find(int id);
    Iterable<Person> find(String lastName);
    Iterable<Person> find(int minAge, int maxAge);
    Iterable<Person> find(LocalDate minAge, LocalDate maxAge);
    Iterable<Person> getAllPersonsSortedByID();
    Iterable<Person> getAllPersonsSortedByAge();
    Iterable<Person> getAllPersonsSortedByLastName();
    Iterable<Person> getAllPersonsSortedByDate();
    int size();
}
