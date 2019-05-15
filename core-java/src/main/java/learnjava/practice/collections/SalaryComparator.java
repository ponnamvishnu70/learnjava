package learnjava.practice.collections;

import java.util.Comparator;

import learnjava.practice.model.Person;

public class SalaryComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getSalary()-o2.getSalary();
	
	}

}
