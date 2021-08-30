package comparators;

import models.Person;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int res = o1.getLastName().compareTo(o2.getLastName());
        if (res != 0){
            return res;
        }
        return Integer.compare(o1.getId(), o2.getId());
    }
}
