package learnjava.practice.designpatterns.creational;
//Decorator Pattern
public class DecoratorPizza implements Pizza {
	public Pizza pizza;

	DecoratorPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void bake() {
		pizza.bake();

	}

	@Override
	public int getCost() {		
		return pizza.getCost();
	}
}
