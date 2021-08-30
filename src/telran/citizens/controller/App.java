package telran.citizens.controller;

import telran.citizens.dao.Citizens;
import telran.citizens.model.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(2, "Mary", "Jackson", 21));
        people.add(new Person(1, "Tonya", "Smith", 23));
        people.add(new Person(8, "John", "Jackson", 24));
        people.add(new Person(5, "Tigran", "Asterics", 25));
        people.add(new Person(18, "John", "Jackson", 24));
        people.add(new Person(12, "John", "Jackson", 24));

        Citizens citizens = new Citizens(people);

//        System.out.println(citizens.size());
//        citizens.add(new Person(3, "Tigran", "Smith", 25));
//        System.out.println(citizens.size());
//        citizens.remove(2);
//        System.out.println(citizens.find(2));
//        citizens.remove(1);
//       System.out.println(citizens.find(5));
        System.out.println(citizens.find(4));


//        System.out.println(citizens.getAllPersonSortedById());


    }
}
