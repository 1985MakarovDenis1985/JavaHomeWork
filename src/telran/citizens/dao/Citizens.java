package telran.citizens.dao;

import java.util.*;

import telran.citizens.interfaces.ICitizens;
import telran.citizens.model.Person;

public class Citizens implements ICitizens {
    private TreeSet<Person> idList = new TreeSet<>((o1, o2) -> {
        return Integer.compare(o1.getId(), o2.getId());
    });
    private TreeSet<Person> lastNameList = new TreeSet<>((o1, o2) -> {
        int res = o1.getLastName().compareTo(o2.getLastName());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    });
    private TreeSet<Person> ageList = new TreeSet<>((o1, o2) -> {
        int res = Integer.compare(o1.getAge(), o2.getAge());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    });


    public Citizens() {

    }

    public Citizens(List<Person> citizens) {
        idList.addAll(citizens);
        lastNameList.addAll(citizens);
        ageList.addAll(citizens);
    }

    @Override
    public boolean add(Person person) {
        if (person == null) {
            return false;
        }

        lastNameList.add(person);
        ageList.add(person);
        return idList.add(person);
    }

    @Override
    public boolean remove(int id) {
        Person victim = find(id);
        if (victim == null) {
            return false;
        }
        idList.remove(victim);
        ageList.remove(victim);
        lastNameList.remove(victim);
        return true;
    }

    @Override
    public Person find(int id) {
        Person pattern = idList.floor(new Person(id, "", "", 0));
        if (pattern.getId() == id) return pattern;

//        for (Person p : idList) {
//            if (p.getId() == id) {
//                return p;
//            }
//        }
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Person pattern1 = new Person(Integer.MIN_VALUE, "", "", minAge);
        Person pattern2 = new Person(Integer.MAX_VALUE, "", "", maxAge);
        return ageList.subSet(pattern1, true, pattern2, true);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        Person pattern1 = new Person(Integer.MIN_VALUE, "", lastName, 0);
        Person pattern2 = new Person(Integer.MAX_VALUE, "", lastName, 0);
        return lastNameList.subSet(pattern1, true, pattern2, true);
    }

    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return lastNameList;
    }

    @Override
    public int size() {
        return idList.size();
    }

}
