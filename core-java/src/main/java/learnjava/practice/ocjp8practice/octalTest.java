package learnjava.practice.ocjp8practice;

public class octalTest {
	int x = 013;// number 0 before number will be converted to octal numbers

	public static void main(String[] args) {
		octalTest ot = new octalTest();
		ot.go(22);
	}

	void go(final int i) {
		System.out.println(x);
		System.out.print(i / x);
	}
}