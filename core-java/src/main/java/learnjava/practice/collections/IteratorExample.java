package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	public static void main(String[] args) {
		String[] namesArray = { "apple", "orange", "grapes", "blueberry" };
		List<String> namelist = Arrays.asList(namesArray);
		List<String> companies = new ArrayList<String>();
		companies.add("google");
		companies.add("microsoft");
		companies.add("ebay");
		//Iterator
		Iterator<String> itr = companies.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			//itr.remove(); will work
			//companies.remove(1); exception
			}
		System.out.println("-------------------");
		//For loop to iterate over Collection
		for(int i=0; i < namelist.size() ;i++) {
			System.out.println(namelist.get(i));			
		}
		//For each element in companies
		for(String c : companies) {
			System.out.println(c);
		}
		
		//Lambdas java 8
		companies.forEach((s)->{System.out.println(s);});
		
	}

}
