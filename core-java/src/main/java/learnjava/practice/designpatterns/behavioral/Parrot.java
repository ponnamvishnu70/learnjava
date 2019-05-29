package learnjava.practice.designpatterns.behavioral;

public class Parrot extends Animal{
	
	public Parrot() {
		this.flys= new CanFly();
	}
	
	@Override
	void eat() {
		// TODO Auto-generated method stub
		super.eat();
	}

}
