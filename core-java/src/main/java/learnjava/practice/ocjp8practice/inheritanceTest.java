package learnjava.practice.ocjp8practice;

public class inheritanceTest {
	public static void main(String args[]) {
		A ab = new B();
		System.out.println(B.j);
		System.out.println(053);
	}
}

class A {
	protected int x = 10;
	static int j = 21;
}

class B extends A {
	
}
