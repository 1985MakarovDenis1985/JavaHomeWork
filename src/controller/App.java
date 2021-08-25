package controller;

import comparators.AgeComparator;
import dao.Citizens;
import models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class App {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(2, "John", "Smith", 25));
        people.add(new Person(1, "Mary", "Jackson", 21));
        people.add(new Person(3, "Tigran", "Petrosian", 23));
        people.add(new Person(1, "Mary", "Jackson", 21));

        Citizens citizens = new Citizens(people);
//        System.out.println(citizens.size());


//        Iterator<Person> iterator = citizens.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}
