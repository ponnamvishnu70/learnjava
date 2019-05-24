package learnjava.practice.multithreading;

public class ParentChildThreadLocalExample {

	public static void main(String[] args) {
		ParentThread p = new ParentThread();
		p.start();
	}
}
