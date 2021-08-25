package comparators;

import models.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() > o2.getAge()){
            return 1;
        }
        if (o1.getAge() < o2.getAge()){
            return -1;
        }
        return 0;
    }
}
