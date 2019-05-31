package learnjava.practice.ocjp8practice;

class Person {
	Person() {
		System.out.print("34 ");
	}

	static {
		System.out.print("12 ");
	}
}

class Manager extends Person {
	Manager() {
		System.out.print("78 ");
	}

	{
		System.out.print("56 ");
	}
}

public class BlockCodeExecOrder {
	public static void main(String[] args) {
		Person p1 = new Manager();
	}
}
