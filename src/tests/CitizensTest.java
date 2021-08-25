package tests;

import dao.Citizens;
import interfaces.ICitizens;
import models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensTest{

    ICitizens citizens;

    @BeforeEach
    void setUp() {
        citizens = new Citizens(Arrays.asList(
                new Person(1, "Peter", "Jackson", 23),
                new Person(2, "John", "Smith", 20),
                new Person(3, "Mary", "Jackson", 20),
                new Person(4, "Tigran", "Petrosian", 25)
                ));
    }

    @Test
    void testAdd() {
        assertFalse(citizens.add(new Person(2, "John", "Smith", 20)));
        assertEquals(4, citizens.size());
        assertTrue(citizens.add(new Person(5, "Pony", "Smith", 27)));
        assertEquals(5, citizens.size());

    }

    @Test
    void testRemove() {
        assertFalse(citizens.remove(5));
        assertEquals(4, citizens.size());
        assertFalse(citizens.remove(2));
        assertEquals(3, citizens.size());

    }

    @Test
    void testFind() {
        Person person = citizens.find(1);
        assertEquals("Peter", person.getFirstName());
        assertEquals("Jackson", person.getLastName());
        assertEquals(23, person.getAge());
        assertEquals(1, person.getId());
        assertNull(citizens.find(5));
    }

    @Test
    void testFindLastName() {
        Iterable<Person> persons = citizens.find("Jackson");
        Person[] expected = {
                new Person(1, "Peter", "Jackson", 23),
                new Person(3, "Mary", "Jackson", 20),
        };
        List<Person> tmp = new ArrayList<>();
        for (Person person : persons) {
            tmp.add(person);
        }
        Collections.sort(tmp);
        Person[] actual = tmp.toArray(new Person[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFindAgeAge() {
        Iterable<Person> persons = citizens.find(20,23);
        Person[] expected = {
                new Person(1, "Peter", "Jackson", 23),
                new Person(2, "John", "Smith", 20),
                new Person(3, "Mary", "Jackson", 20),
        };
        List<Person> tmp = new ArrayList<>();
        for (Person person : persons) {
            tmp.add(person);
        }
        Collections.sort(tmp);
        Person[] actual = tmp.toArray(new Person[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetAllPersonsSortedByID() {
        Iterable<Person> people = citizens.getAllPersonsSortedByID();
        int id = Integer.MIN_VALUE;
        for (Person person : people) {
            assertTrue(person.getId() > id);
            id = person.getId();
        }
    }

    @Test
    void testGetAllPersonsSortedByAge() {
        Iterable<Person> people = citizens.getAllPersonsSortedByAge();
        int age = Integer.MIN_VALUE;
        for (Person person : people) {
            assertTrue(person.getAge() >= age);
            age = person.getAge();
        }
    }

    @Test
    void testGetAllPersonsSortedByLastName() {
        Iterable<Person> people = citizens.getAllPersonsSortedByLastName();
        String lastName = "";
        for (Person person : people) {
            assertTrue(person.getLastName().compareTo(lastName) >= 0);
            lastName = person.getLastName();
        }
    }

    @Test
    void testSize() {
        assertEquals(4, citizens.size());
    }

    @Test
    void testConstructor() {
        citizens = new Citizens(Arrays.asList(
                new Person(1, "Peter", "Jackson", 23),
                new Person(1, "Peter", "Jackson", 23)
        ));
        assertEquals(1, citizens.size());
    }
}