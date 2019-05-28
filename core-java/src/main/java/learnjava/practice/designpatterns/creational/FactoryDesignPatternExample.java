package learnjava.practice.designpatterns.creational;

public class FactoryDesignPatternExample {
	public static void main(String[] args) {
		Acura ilx = AcuraFactory.getCar(Car.ILX);
		ilx.move();

	}
}

class AcuraFactory {
	static Acura getCar(Car car) {
		if ("Ilx".equalsIgnoreCase(car.getValue())) {
			return new Ilx();
		} else if ("Tlx".equalsIgnoreCase(car.getValue())) {
			return new Tlx();
		} else if ("Rdx".equalsIgnoreCase(car.getValue())) {
			return new Rdx();
		}
		return null;

	}
}

enum Car {
	ILX("Ilx"), TLX("Tlx"), RDX("Rdx");
	private String value;

	Car(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
}

class Tlx implements Acura {
	int carSize = 2;

	@Override
	public void move() {
		System.out.println("Tlx is moving");
	}
}

class Ilx implements Acura {
	int carSize = 1;

	@Override
	public void move() {
		System.out.println("Ilx is moving");
	}
}

class Rdx implements Acura {
	int carSize = 3;

	@Override
	public void move() {
		System.out.println("Rdx is moving");
	}
}

interface Acura {
	int carSize = 0;

	void move();

}