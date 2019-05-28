package learnjava.practice.designpatterns.structural;

//Decorator Pattern
public class BasicPizza implements Pizza {

	@Override
	public void bake() {
		System.out.println("Baking basic pizza");		
	}

	@Override
	public int getCost() {
		return 10;
	}

}
