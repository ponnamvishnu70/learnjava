package learnjava.practice.stringarraynumbers;

import learnjava.practice.model.Person;

public class ArrayExample {

	// declaring array
	int[] intArray;
	String[] stringArray;
	Person[] personArray;

	//ArrayLiteral different ways to instantiate array
	//declare and instantiate in single line
	int[] int2 = new int[] {1,2,3};
	int[] int3 = {1,2,3,4}; 

	private void doSomething() {
		//Once array is created it cannot be resized
		intArray = new int[10];
		stringArray = new String[10];
		personArray = new Person[10];
		//declare and instantiate in single line
		int[] inteArray= new int[13];
		int arraylength = intArray.length;
		for(int i=0; i<int2.length;i++) {
			System.out.println(int2[i]);
		}
	}	
	
	public static void main(String[] args) {
		ArrayExample arrayExample = new ArrayExample();
		arrayExample.doSomething();
	}
}
