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
        people.add(new Person(2, "John", "Smith", 29));
        people.add(new Person(1, "Mary", "Jackson", 21));
        people.add(new Person(5, "Tigran", "Petrosian", 25));
        people.add(new Person(1, "Mary", "Jackson", 21));

        Citizens citizens = new Citizens(people);
        citizens.add(new Person(4, "Mary", "Jackson", 22));
        citizens.add(new Person(3, "Mary", "Jackson", 26));
        citizens.add(new Person(6, "Mary", "Jackson", 27));


//        System.out.println(citizens.find(2));
        citizens.find(12, 25);
//        citizens.remove(7);


//        System.out.println(citizens.size());


//        System.out.println("============= iterator =============");
//        Iterator<Person> iterator = citizens.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}
