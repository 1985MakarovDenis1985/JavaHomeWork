package dao;

import interfaces.ICitizens;
import models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Citizens implements ICitizens {
    List<Person> idList;
    List<Person> lastNamesList;
    List<Person> ageList;
    static Comparator<Person> lastNameComparator;
    static Comparator<Person> ageComparator;

    public Citizens() {

    }

    public Citizens(List<Person> citizens) {
        idList = new ArrayList<>(citizens);
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByID() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return null;
    }

    @Override
    public int size() {
        return idList.size();
    }


    public Iterator<Person> iterator() {
        return idList.iterator();
    }
}
