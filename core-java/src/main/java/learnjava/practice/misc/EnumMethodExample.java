package learnjava.practice.misc;

public class EnumMethodExample {
	public static void main(String[] args) {
		Food chicken = Food.CHICKEN;
		Food fish = Food.CHICKEN;
		System.out.println(chicken);
		chicken.eating();
		fish.eating();
	}
}
