package learnjava.practice.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		System.out.println(numbers.get(null));
		
	}

	}
