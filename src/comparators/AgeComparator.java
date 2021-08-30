package comparators;

import models.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int res = Integer.compare(o1.getAge(), o2.getAge());
        if (res != 0){
            return res;
        }
        return Integer.compare(o1.getId(), o2.getId());
    }
}
