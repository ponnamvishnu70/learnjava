package learnjava.practice.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import learnjava.practice.model.Person;

//Order not guaranteed
//No Duplicates .
//Backed by Hasmap internally 
//All the objects stored in hashset are stored in hashmap 
//as key and with common default values(Object present = new Object)
//time complexity for add, remove and contains 
//operation of HashSet is O(1)
public class SetExample {

	public static void main(String[] args) {
		Set s = new HashSet<>();
		Person p = new Person("vishnu", "ponnam");
		p.setAge(28);
		Person p1 = new Person("vishnu", "ponnam");
		p1.setAge(28);
		Person p2 = new Person("ponnam", "vishnu");
		p2.setAge(28);
		s.add(p);
		s.add(p1);
		s.add(p2);		
		s.iterator();
		System.out.println(s);
	}
}
