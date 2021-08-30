package comparators;

import models.Person;

import java.util.Comparator;

public class DateComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
       int res = o1.getDate().compareTo(o2.getDate());
       if (res != 0){
           return res;
       }
        return Integer.compare(o1.getId(), o2.getId());
    }
}
