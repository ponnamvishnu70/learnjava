package learnjava.practice.ocjp8practice;

public class NumberTest {
	public static void main(String[] args) {
		Object obj = new Double(3);
		Number num = (Number) obj;
		Number doublenum = 123.546;
		Double d = (Double)doublenum;
		System.out.println(num);
		System.out.println(d);
	}
}