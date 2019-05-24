package learnjava.practice.collections;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import learnjava.practice.model.Person;

public class TreeMapExample {

	public static void main(String[] args) {
		SalaryComparator sc = new SalaryComparator();
		TreeMap<Person, String> persons = new TreeMap<Person, String>(sc);
		Person p = new Person("vishnu", "ponnam", 28);
		Person p1 = new Person("vishnu1", "ponnam1", 29);
		p.setSalary(8000);
		p1.setSalary(9000);
		Person p2 = new Person("vishnu2", "ponnam2", 30);
		Person p3 = new Person("vishnu3", "ponnam1", 31);
		p2.setSalary(14000);
		p3.setSalary(7000);
		persons.put(p3, "vishnu3");
		persons.put(p1, "vishnu1");
		persons.put(p, "vishnu");
		persons.put(p2, "vishnu2");
		System.out.println(persons);
		Set<Entry<Person, String>> personentry = persons.entrySet();
		personentry.forEach((s) -> {
			System.out.println(s.getKey());
			System.out.println(s.getValue());
		});
		Iterator<Entry<Person, String>> itr = personentry.iterator();
		while (itr.hasNext()) {
			Entry<Person, String> e = itr.next();
			System.out.println("Itr - Key" + e.getKey());
			System.out.println("Itr - Value" + e.getValue());

		}
	}

}
