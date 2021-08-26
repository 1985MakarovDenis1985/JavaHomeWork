package dao;

import comparators.AgeComparator;
import comparators.LastNameComparator;
import interfaces.ICitizens;
import models.Person;

import java.time.LocalDate;
import java.util.*;

public class Citizens implements ICitizens {
    private List<Person> idList;
    private List<Person> lastNamesList;
    private List<Person> ageList;
    private List<Person> dateList;
//    private static Comparator<Person> lastNameComparator = new LastNameComparator(); // static инициализируем только в этом месте
//    private static Comparator<Person> ageComparator = new AgeComparator();
//
//    private static Comparator<Person> lastNameComparator
//    private static Comparator<Person> ageComparator
//    static {
//        lastNameComparator = (o1, o2) -> {
//            int res = o1.getLastName().compareTo(o2.getLastName());
//            return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
//        };
//        ageComparator = (o1, o2) -> {
//            int res = Integer.compare(o1.getAge(), o2.getAge());
//            return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
//        };
//        dateComparator = (o1, o2) -> {
//            int res = o1.getDate().compareTo(o2.getDate());
//            return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
//        };
//    }

//      // --- class --- // --- with lamda ---
    private static Comparator<Person> lastNameComparator = (o1, o2) -> {
        int res = o1.getLastName().compareTo(o2.getLastName());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    };
    private static Comparator<Person> ageComparator = (o1, o2) -> {
        int res = Integer.compare(o1.getAge(), o2.getAge());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    };
    private static Comparator<Person> dateComparator = (o1, o2) -> {
        int res = o1.getDate().compareTo(o2.getDate());
        return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
    };
//      // --- class --- //

    public Citizens() {
        idList = new ArrayList<>();
        ageList = new ArrayList<>();
        lastNamesList = new ArrayList<>();
        dateList = new ArrayList<>();
    }

    public Citizens(List<Person> citizens) {
//      // --- class --- //
//        List<Person> people = new ArrayList<>();
//        for (Person person : citizens) {
//            if (person != null && !people.contains(person)){
//                people.add(person);
//            }
//        }
//      // --- class --- //

        ArrayList<Person> temp = new ArrayList<>(citizens);
        removeRepeated(temp);

        idList = new ArrayList<>(temp);
        Collections.sort(idList);

        ageList = new ArrayList<>(temp);
        Collections.sort(ageList, ageComparator);

        lastNamesList = new ArrayList<>(temp);
        Collections.sort(lastNamesList, lastNameComparator);

        dateList = new ArrayList<>(temp);
        Collections.sort(dateList, dateComparator);
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
//      // --- class --- //
//        if (person == null) {
//            return false;
//        }
//      // --- class --- //
        int indexId = Collections.binarySearch(idList, person);
        if (indexId >= 0) return false;
        idList.add(-indexId - 1, person);

        int indexAge = Collections.binarySearch(ageList, person, ageComparator);
        if (indexAge < 0) {
            ageList.add(-indexAge - 1, person);
        } else {
            ageList.add(indexAge, person);
        }

        // --- date ---
        int indexDate = Collections.binarySearch(dateList, person, dateComparator);
        if (indexDate < 0) {
            dateList.add(-indexDate - 1, person);
        } else {
            dateList.add(indexDate, person);
        }
        // --- date ---

        int indexLastName = Collections.binarySearch(lastNamesList, person, lastNameComparator);
        if (indexLastName < 0) {
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
        int index = Collections.binarySearch(idList, new Person(id, " ", " ", 0, LocalDate.of(1985, 4, 23)));
        if (index < 0) return null;
        return idList.get(index);
    }

    @Override
    public Iterable<Person> find(String lastName) {
        Person p1 = new Person(Integer.MIN_VALUE, " ", lastName, 0, LocalDate.of(1989, 4, 23));
        Person p2 = new Person(Integer.MAX_VALUE, " ", lastName, 0, LocalDate.of(1995, 4, 23));

        int indexStart = Collections.binarySearch(lastNamesList, p1, lastNameComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;

        int indexFinal = Collections.binarySearch(lastNamesList, p2, lastNameComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal : -indexFinal - 1;

        return lastNamesList.subList(indexStart, indexFinal);
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        // --- class --- //
//        Person p1 = new Person(idList.get(0).getId() - 1, " ", " ", 0, minAge);
//        Person p2 = new Person(idList.get(idList.size() - 1).getId() + 1, " ", " ", 0, maxAge);
        // --- class --- //

        Person p1 = new Person(Integer.MIN_VALUE, " ", " ", minAge, LocalDate.of(1978, 4, 23));
        Person p2 = new Person(Integer.MAX_VALUE, " ", " ", maxAge, LocalDate.of(1996, 4, 23));

        int indexStart = Collections.binarySearch(ageList, p1, ageComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;

        int indexFinal = Collections.binarySearch(ageList, p2, ageComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal : -indexFinal - 1;

        return ageList.subList(indexStart, indexFinal);
    }

    @Override // ------------ local date -------------- //
    public Iterable<Person> find(LocalDate minAge, LocalDate maxAge) {
        Person p1 = new Person(idList.get(0).getId() - 1, " ", " ", 0, minAge);
        Person p2 = new Person(idList.get(idList.size() - 1).getId() + 1, " ", " ", 0, maxAge);

        int indexStart = Collections.binarySearch(dateList, p1, dateComparator);
        indexStart = (indexStart >= 0) ? indexStart : -indexStart - 1;

        int indexFinal = Collections.binarySearch(dateList, p2, dateComparator);
        indexFinal = (indexFinal >= 0) ? indexFinal : -indexFinal - 1;

        return dateList.subList(indexStart, indexFinal);
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
