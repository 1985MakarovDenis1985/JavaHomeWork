package telran.citizens.dao;

import java.util.*;

import telran.citizens.interfaces.ICitizens;
import telran.citizens.model.Person;

public class Citizens implements ICitizens {
    private Set<Person> idList = new HashSet<>();
    private TreeSet<Person> lastNameList = new TreeSet<>(lastNameComparator);
    private TreeSet<Person> ageList = new TreeSet<>(ageComparator);

    private static Comparator<Person> lastNameComparator = (o1, o2) -> {
        int res = o1.getLastName().compareTo(o2.getLastName());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    };
    private static Comparator<Person> ageComparator = (o1, o2) -> {
        int res = Integer.compare(o1.getAge(), o2.getAge());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    };

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
        Person pattern = new Person(id, null, null, 0);
        if (idList.contains(pattern)) {
            for (Person p : idList) {
                if (p.getId() == id) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Person pattern1 = new Person(Integer.MIN_VALUE, null, null, minAge);
        Person pattern2 = new Person(Integer.MAX_VALUE, null, null, maxAge);
        return ageList.subSet(pattern1, true, pattern2, true);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        Person pattern1 = new Person(Integer.MIN_VALUE, null, lastName, 0);
        Person pattern2 = new Person(Integer.MAX_VALUE, null, lastName, 0);
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
