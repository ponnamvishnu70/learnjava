package learnjava.practice.constructor;

public class ConstructorExample {

	// Instance variables have default values.
	// For numbers, the default value is 0, for Booleans it is false,
	/// and for object references it is null
	private int i;
	private int j;

	// No-arg Constructor. if no constructor is defined compiler will add this
	// default constructor
	public ConstructorExample() {
		System.out.println("in parent");
	}

	// Parameterized constructor to initialize instance variables
	public ConstructorExample(int i) {
		System.out.println("in parent arg constructor");
		// keyword this is a reference variable for current class object
		// this is can be usefull for calling overloaded construtor
		this.i = i;
		System.out.println(j);
	}

}
