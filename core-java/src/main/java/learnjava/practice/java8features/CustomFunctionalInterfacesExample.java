package learnjava.practice.java8features;

public class CustomFunctionalInterfacesExample {
	public static void main(String[] args) {
		CustomFunctionalInterfaces c = () -> {
			System.out.println("print from Functional Interface");
		};
		c.print();
		
	}
}
