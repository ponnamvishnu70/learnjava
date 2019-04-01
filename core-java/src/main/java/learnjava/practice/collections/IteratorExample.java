package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		Iterator<String> itr = companies.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
			//companies.remove(1); exception
			}
		System.out.println("-------------------");
		for(int i=0; i < namelist.size() ;i++) {
			System.out.println(namelist.get(i));			
		}
	}

}
