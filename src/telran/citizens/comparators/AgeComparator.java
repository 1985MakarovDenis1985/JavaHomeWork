package telran.citizens.comparators;

import java.util.Comparator;

import telran.citizens.model.Person;

public class AgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int res = Integer.compare(o1.getAge(), o2.getAge());
		return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
	}

}
