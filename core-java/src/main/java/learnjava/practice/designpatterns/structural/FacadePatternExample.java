package learnjava.practice.designpatterns.structural;

//Facade Design pattern - Interface that can act as entry to many services
public class FacadePatternExample {
	Pizza basicPizza;
	Vehicle vehicle;
	
	FacadePatternExample(){
		basicPizza = new BasicPizza();
	    vehicle = new Vehicle();
	}
	
	void bakeBasicPizza(){
		basicPizza.bake();
	}
	
	void vehicleMoving() {
		vehicle.move();
	}
	
	public static void main(String[] args) {
		FacadePatternExample fex= new FacadePatternExample();
		fex.bakeBasicPizza();
	}

}


