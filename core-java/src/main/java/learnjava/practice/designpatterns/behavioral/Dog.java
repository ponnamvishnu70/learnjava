package learnjava.practice.designpatterns.behavioral;

public class Dog extends Animal {
	
	public Dog() {
		this.flys = new CantFly();
	}

	@Override
	void eat() {
		// TODO Auto-generated method stub
		super.eat();
	}
	
	
}
