package controller;

import dao.Citizens;
import models.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(2, "John", "Smith", 20));
        people.add(new Person(3, "Mary", "Jackson", 20));
        people.add(new Person(4, "Tigran", "Petrosian", 23));

        Citizens citizens = new Citizens(people);
        System.out.println(citizens.size());

        Iterator<Person> iterator = citizens.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
