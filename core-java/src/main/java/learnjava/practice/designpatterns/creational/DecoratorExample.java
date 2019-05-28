package learnjava.practice.designpatterns.creational;
//Decorator Pattern
public class DecoratorExample {
	
	public static void main(String[] args) {
		
		Pizza pizza = new Jalapenos(new BasicPizza());
		pizza.bake();
		
	}

}
