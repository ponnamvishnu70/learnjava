package learnjava.practice.designpatterns.structural;

//Decorator Pattern
public class DecoratorExample {
	
	public static void main(String[] args) {
		
		Pizza pizza = new Jalapenos(new BasicPizza());
		pizza.bake();
		
	}

}
