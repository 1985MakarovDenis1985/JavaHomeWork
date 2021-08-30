package telran.citizens.comparators;

import java.util.Comparator;

import telran.citizens.model.Person;

public class LastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int res = o1.getLastName().compareTo(o2.getLastName()); 
		return res != 0 ? res : Integer.compare(o1.getId(), o2.getId());
	}

}
