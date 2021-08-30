package controller;

import comparators.AgeComparator;
import dao.Citizens;
import models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class App {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(2, "John", "Jackson", 21, LocalDate.of(2000, 4, 23)));
        people.add(new Person(8, "Tonya", "Smith", 23, LocalDate.of(1998, 4, 23)));
        people.add(new Person(1, "Mary", "Apach", 24, LocalDate.of(1997, 4, 23)));
        people.add(new Person(5, "Tigran", "Petrosian", 25, LocalDate.of(1996, 4, 23)));
//        people.add(new Person(1, "Mary", "Jackson", 21, LocalDate.of(1989, 4, 23)));
        Citizens citizens = new Citizens(people);
//
//        citizens.add(new Person(4, "Tonya", "Jackson", 29, LocalDate.of(1992, 4, 23)));
//        citizens.add(new Person(7, "Dodik", "Jackson", 22, LocalDate.of(1999, 4, 23)));
//        citizens.add(new Person(1, "Mary", "Jackson", 26));
//        citizens.add(new Person(6, "Tonya", "Jackson", 21, LocalDate.of(2000, 4, 23)));
//        citizens.add(new Person(1, "Mary", "Jackson", 21));
        citizens.add(new Person(9, "Tonya", "Smith", 22, LocalDate.of(1997, 4, 23)));


//        System.out.println(citizens.find("Jackson"));

//        System.out.println(citizens.find(2));
//        System.out.println(citizens.find(12, 23));
//        System.out.println(citizens.find(LocalDate.of(1996, 1, 23), LocalDate.of(1998, 12, 23)));
System.out.println(citizens.getAllPersonsSortedByDate());


//        citizens.remove(7);

//        System.out.println(citizens.size());
//
//        citizens.find(12, 25);


//        System.out.println("============= iterator =============");
//        Iterator<Person> iterator = citizens.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}
