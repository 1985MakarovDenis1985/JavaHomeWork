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
        people.add(new Person(2, "John", "Jackson", 21));
        people.add(new Person(8, "Tonya", "Smith", 23));
        people.add(new Person(1, "Mary", "Apach", 24));
        people.add(new Person(5, "Tigran", "Petrosian", 25));
//        people.add(new Person(1, "Mary", "Jackson", 21));
        Citizens citizens = new Citizens(people);
//
        citizens.add(new Person(4, "Tonya", "Jackson", 29));
        citizens.add(new Person(7, "Dodik", "Jackson", 22));
//        citizens.add(new Person(1, "Mary", "Jackson", 26));
        citizens.add(new Person(6, "Tonya", "Jackson", 21));
//        citizens.add(new Person(1, "Mary", "Jackson", 21));

//        System.out.println(citizens.find("Jackson"));

//        System.out.println(citizens.find(2));
        System.out.println(citizens.find(12, 23));

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
