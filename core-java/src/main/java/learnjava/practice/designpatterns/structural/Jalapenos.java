package learnjava.practice.designpatterns.structural;

//Decorator Pattern
public class Jalapenos extends DecoratorPizza{

	Jalapenos(Pizza pizza) {
		super(pizza);
	}
	
	
	@Override
	public void bake() {
		pizza.bake();
	      System.out.println("with jalapenos");	
	}
	
	@Override
	public int getCost() {
		return pizza.getCost() + 2;
	}

}
