package learnjava.practice.java8features;

public interface FirstInterface {
 default void method1() {
	 System.out.println("from second interface");
 }
}
