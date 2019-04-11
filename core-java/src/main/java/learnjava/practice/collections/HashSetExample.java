package learnjava.practice.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *No Duplicates allowed
 *No order Guaranteed
 *Backed up by HashMap
 *
 */
public class HashSetExample {
	public static void main(String[] args) {
		Set<String> countries = new HashSet<String>();
		countries.add("India");
		countries.add("USA");
		countries.add("Mexico");
		countries.add("England");	
		//insertion order not guaranteed
		countries.forEach(s->{System.out.println(s);});
		countries.remove("India");
		for(String country : countries) {
			System.out.println(country);
			countries.remove("Canada");
		}
		Iterator<String> countryy= countries.iterator();
		while(countryy.hasNext()) {
			String s= countryy.next();
			System.out.println(s);
			//countries.remove("Mexico");
			//this will throw an ConcurrentModificationException error
			//have to use iterator remove method
			countryy.remove();
		}
		countries.add("Australia");
		countries.add("South Africa");
		
		countries.forEach(s->{System.out.println(s);});
	}
}
