package interfaces;

import models.Person;

public interface ICitizens {
    boolean add(Person person);
    boolean remove(int id);
    Person find(int id);
    Iterable<Person> find(String lastName);
    Iterable<Person> find(int minAge, int maxAge);
    Iterable<Person> getAllPersonsSortedByID();
    Iterable<Person> getAllPersonsSortedByAge();
    Iterable<Person> getAllPersonsSortedByLastName();
    int size();
}
