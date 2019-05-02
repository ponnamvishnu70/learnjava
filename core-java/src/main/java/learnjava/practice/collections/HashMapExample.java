package learnjava.practice.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import learnjava.practice.model.Person;
//Hash map allows one null key and any null values
//Hashtable doesn't allow null key or values
//HashMap is  preferred over HashTable if no synchronization  needed
public class HashMapExample {
	public static void main(String[] args) {
		HashMap<String, String> numbers = new HashMap<String, String>();
		numbers.put("1", "one");
		numbers.put("2", "two");
		numbers.put("3", "three");
		numbers.put("4", "four");
		numbers.put("5", "five");
		numbers.put("6", "six");
		//Can store one null key
		numbers.put(null, "six");
		//previous stored null key valye will be overriden
		numbers.put(null, null);
		System.out.println(numbers.get("1"));
		//returns set of keys
		numbers.keySet();
		numbers.values();
		Set<Entry<String, String>> s = numbers.entrySet();
		Iterator<Map.Entry<String, String>> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().getKey());
}
		//System.out.println(numbers.get(null));
		
		Map<Person,String> persons = new HashMap<Person,String>();
		Person p = new Person("vishnu","ponnam",28);
		Person p1 = new Person("vishnu1","ponnam1",29);
		persons.put(p, "vishnu");
		persons.put(p1, "vishnu1");
		p.setAge(30);
		System.out.println(persons.get(p));
		
		
	}

	}
