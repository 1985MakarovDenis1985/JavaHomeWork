package dao;

import comparators.AgeComparator;
import comparators.LastNameComparator;
import interfaces.ICitizens;
import models.Person;
import java.util.*;

public class Citizens implements ICitizens {
    private List<Person> idList;
    private List<Person> lastNamesList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator = new LastNameComparator(); // static инициализируем только в этом месте
    private static Comparator<Person> ageComparator = new AgeComparator();

    public Citizens() {
        idList = new ArrayList<>();
        ageList = new ArrayList<>();
        lastNamesList = new ArrayList<>();
    }

    public Citizens(List<Person> citizens) {
        ArrayList<Person> temp = new ArrayList<>(citizens);
        removeRepeated(temp);

        idList = new ArrayList<>(temp);
        Collections.sort(idList);

        ageList = new ArrayList<>(temp);
        Collections.sort(ageList, ageComparator);

        lastNamesList = new ArrayList<>(temp);
        Collections.sort(lastNamesList, lastNameComparator);
    }

    private void removeRepeated(List arr) {
        for (Object i : arr) {
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

        int indexLastName = Collections.binarySearch(lastNamesList, person, lastNameComparator);
        if (indexLastName < 0){
            lastNamesList.add(-indexLastName - 1, person);
        } else {
            lastNamesList.add(indexLastName, person);
        }

        return true;
    }

    @Override
    public boolean remove(int id) {
        Person p = find(id);
        if (p == null) return false;
        idList.remove(p);
        ageList.remove(p);
        lastNamesList.remove(p);
        return false;
    }

    @Override
    public Person find(int id) {
        int index = Collections.binarySearch(idList, new Person(id, " ", " ", 0));
        if (index < 0) return null;
        return idList.get(index);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        Person p1 = new Person(Integer.MIN_VALUE, " ", lastName, 0);
        Person p2 = new Person(Integer.MAX_VALUE, " ", lastName, 0);

        int indexStart = Collections.binarySearch(lastNamesList, p1, lastNameComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;

        int indexFinal = Collections.binarySearch(lastNamesList, p2, lastNameComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal: -indexFinal - 1;

        return lastNamesList.subList(indexStart, indexFinal);
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Person p1 = new Person(Integer.MIN_VALUE, " ", " ", minAge);
        Person p2 = new Person(Integer.MAX_VALUE, " ", " ", maxAge);

        int indexStart = Collections.binarySearch(ageList, p1, ageComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;

        int indexFinal = Collections.binarySearch(ageList, p2, ageComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal: -indexFinal - 1;

        return ageList.subList(indexStart, indexFinal);
    }


    @Override
    public Iterable<Person> getAllPersonsSortedByID() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return lastNamesList;
    }

    @Override
    public int size() {
        return idList.size();
    }
}
