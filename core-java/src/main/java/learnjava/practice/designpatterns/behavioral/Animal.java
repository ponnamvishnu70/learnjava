package learnjava.practice.designpatterns.behavioral;

public class Animal {
	
	public Flys flys;

	void eat() {
		System.out.println("Eating........");
	}
	
	void tryToFly(){
		flys.fly();
	}
}
