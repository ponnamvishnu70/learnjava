package learnjava.practice.stringarraynumbers;

import learnjava.practice.model.Person;

public class StringExample {

	public static void main(String[] args) {
		

		// This is called string literal. these string are stored in string pool
		String testliteral = "Hello World";
		// if you create same string by string literal way,
		// JVM may only create single instance and
		// newly created string will be pointing to that memory location
		String anothertestliteral = "Hello World";

		if (testliteral == anothertestliteral) {
			// As they point to same memory location ,this if condition is true
			System.out.println("inside string literal comparison");

		}

		// If you want to create different memory locations for same string
		String test = new String("Hello World");
		String test1 = new String("Hello World");
		if (test == test1) {
			// As they point to DIFFERENT memory location ,this if condition is False
			System.out.println("inside new string comparison");

		}

		// To test Content of two strings ignoring case
		if (test.equalsIgnoreCase(test1)) {
			System.out.println("compared content");

		}
		//Numbers to string
		String inttostring = String.valueOf(10);
	}
}
