package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import learnjava.practice.model.Person;

//Comparator can be used when we want to new type 
//comparison other than default comparison on Person class
public class ComparatorExample {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		Person p = new Person("vishnu","ponnam",28);
		Person p1 = new Person("vishnu1","ponnam1",29);
		p.setSalary(8000);
		p1.setSalary(9000);
		Person p2 = new Person("vishnu2","ponnam2",30);
		Person p3 = new Person("vishnu1","ponnam1",31);
		p2.setSalary(10000);
		p3.setSalary(11000);
		persons.add(p3);
		persons.add(p1);
		persons.add(p);		
		persons.add(p2);
		SalaryComparator sc = new SalaryComparator();
		Collections.sort(persons, sc);
		//Below method will use compareTo of Person class
		//Collections.sort(persons);
		persons.forEach((s)->{
			System.out.println(s);
		});
	}

}
