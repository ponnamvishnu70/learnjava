package learnjava.practice.constructor;

public class ChildConstrutorExample extends ConstructorExample {

	public ChildConstrutorExample() {
		// way to invoke a constructor
		// this and super should always be the first line in a constructor
		this("vishnu");
		System.out.println("in child");

	}

	private ChildConstrutorExample(String s) {
		// super is same as this but to invoke parent class
		super(2);
		System.out.println("in child arg-construtor");

	}

}
