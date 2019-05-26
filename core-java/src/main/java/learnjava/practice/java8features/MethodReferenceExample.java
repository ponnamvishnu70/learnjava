package learnjava.practice.java8features;

import java.util.function.Function;

public class MethodReferenceExample {
	public static void method1() {
		System.out.println("print something");
	}
	public  void method2() {
		System.out.println("print something from instance method");
	}
public static void main(String[] args) {
	Function<String, Double> doubleConvertor = Double::parseDouble;
	Double d = doubleConvertor.apply("0.254");
	System.out.println(d);
	//Method reference : function required for below step is already provided by Method1.
	//So will just refer to that code
	CustomFunctionalInterfaces c =MethodReferenceExample::method1;
	c.print();
	MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
	CustomFunctionalInterfaces c2  = methodReferenceExample::method2;
	c2.print();
}
}
