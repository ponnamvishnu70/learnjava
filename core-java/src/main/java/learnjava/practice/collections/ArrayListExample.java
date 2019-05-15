package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//dynamically growing array
public class ArrayListExample {

	public static void main(String[] args) {
		String[] array = { "mango", "pineapple", "strawberry" };
		// List created in below has fixed size can't be resized
		// changes to list reflects in array too and vice versa
		List<String> arraytolist = Arrays.asList(array);
		System.out.println(array.length);
		array[0] = "apple";
		array[2] = "orange";
		System.out.println(array[1]);
		// add - to add new element
		// set - to replace old element with new at specified index
		arraytolist.set(1, "banana");
		System.out.println(array[1]);
		arraytolist.forEach((s) -> {
			System.out.println(s);
		});
		
		List<String> cars = new ArrayList<>();
		cars.add("Acura");cars.add("BMW");cars.add("Honda");
		cars.add("Benz");cars.add("subaru");cars.add("toyota");
		cars.add("Nissan");cars.add("Ford");cars.add("Audi");
		System.out.println(cars.get(0));
		System.out.println(cars.set(6, "Infiniti"));
		System.out.println(cars.get(6));
		//Below Iterator only for List
		ListIterator<String> listCars = cars.listIterator();
		listCars.next();
		listCars.next();
		while(listCars.hasPrevious()) {
			System.out.println(listCars.previous());
		}
	}
}
