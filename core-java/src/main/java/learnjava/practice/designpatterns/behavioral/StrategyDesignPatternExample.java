package learnjava.practice.designpatterns.behavioral;

public class StrategyDesignPatternExample {
	

	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal parrot = new Parrot();
		dog.tryToFly();
		parrot.tryToFly();
	}
	

}
