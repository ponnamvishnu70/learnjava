package learnjava.practice.java8features;

import java.util.function.Function;

public class MethodReferenceExample {
public static void main(String[] args) {
	Function<String, Double> doubleConvertor = Double::parseDouble;
	Double d = doubleConvertor.apply("0.254");
	System.out.println(d);
}
}
