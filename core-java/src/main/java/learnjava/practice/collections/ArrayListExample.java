package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dynamically growing array
//
public class ArrayListExample {

	public static void main(String[] args) {
		List l = new ArrayList();
		Object[] array = { 1, 2, 3 };
		// List created in below has fixed size can't be resized
		// changes to list reflects in array too and vice versa
		List arraytolist = Arrays.asList(array);
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

	}
}
