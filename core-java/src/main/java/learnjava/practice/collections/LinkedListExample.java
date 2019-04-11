package learnjava.practice.collections;

import java.util.LinkedList;
import java.util.List;


public class LinkedListExample {
	public static void main(String[] args) {
		List<String> linkedlist = new LinkedList<String>();
		linkedlist.add("one");
		linkedlist.add("two");
		linkedlist.add("three");
		linkedlist.add("four");
		linkedlist.add("five");
		linkedlist.add(0,"zero");//this will be added to index specified

		linkedlist.forEach(s->{System.out.println(s);});
		System.out.println(linkedlist.contains("two"));
		System.out.println(linkedlist.indexOf("four"));
	}
}
