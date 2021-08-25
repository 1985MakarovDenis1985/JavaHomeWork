package dao;

import comparators.AgeComparator;
import interfaces.ICitizens;
import models.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

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

        idList = new ArrayList<>(temp);
        Collections.sort(idList);
        ageList = new ArrayList<>(temp);
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
        int indexId = Collections.binarySearch(idList, person);
        if (indexId >= 0) return false;
        idList.add(-indexId - 1, person);

        int indexAge = Collections.binarySearch(ageList, person, ageComparator);
        if (indexAge < 0){
            ageList.add(-indexAge - 1, person);
        } else {
            ageList.add(indexAge, person);
        }

        return true;
    }

    @Override
    public boolean remove(int id) {
        Person p = find(id);
        if (p == null) return false;
        idList.remove(p);
        return false;
    }

    @Override
    public Person find(int id) {
        int index = Collections.binarySearch(idList, new Person(id, " ", " ", 0, LocalDate.of(1988, 1, 21)));
        if (index < 0) return null;
        return idList.get(index);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Person p1 = new Person(0, " ", " ", minAge, LocalDate.of(1988, 1, 21));
        Person p2 = new Person(0, " ", " ", maxAge, LocalDate.of(1988, 1, 21));

        int indexStart = Collections.binarySearch(ageList, p1, ageComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;
//        System.out.println(indexStart);

        int indexFinal = Collections.binarySearch(ageList, p2, ageComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal + 1 : -indexFinal - 1;
//        System.out.println(indexFinal);
//
        List<Person> temp = ageList.subList(indexStart, indexFinal);

        for (Person p : temp) {
            System.out.println(p);
        }

        return temp;
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
