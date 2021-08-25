package dao;

import comparators.AgeComparator;
import interfaces.ICitizens;
import models.Person;

import java.util.*;

public class Citizens implements ICitizens {
    List<Person> idList;
    List<Person> lastNamesList;
    List<Person> ageList;
    static Comparator<Person> lastNameComparator;
    static Comparator<Person> ageComparator = new AgeComparator();

    public Citizens() {
    }

    public Citizens(List<Person> citizens) {
        ArrayList temp = new ArrayList(citizens);
        removeRepeated(temp);
        printArr(temp);


        idList = new ArrayList<>(citizens);
        Collections.sort(idList);
        ageList = new ArrayList<>(citizens);
        Collections.sort(ageList, ageComparator);
//        printArr(ageList);
//        Collections.sort(lastNamesList = new ArrayList<Person>(citizens));
//        Collections.sort(ageList = new ArrayList<Person>(citizens));
    }

    private void removeRepeated(ArrayList arr) {
        Person[] people = (Person[]) arr.toArray(new Person[0]);
        for (Person i : people) {
            if (arr.indexOf(i) != arr.lastIndexOf(i)) {
                arr.remove(arr.lastIndexOf(i));
            }
        }
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

    private void printArr(List arr) {
        for (Object p : arr) {
            System.out.println(p);

        }
    }
}
