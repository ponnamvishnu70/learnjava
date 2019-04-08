package learnjava.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dynamically growing array
//
public class ArrayListExample {

	public static void main(String[] args) {
		List l = new ArrayList();
		Object[] array= {1,2,3,4,5};
		List arraytolist = Arrays.asList(array);
		System.out.println(array.length);
		array[0]="vishnu";
	}
}
