package learnjava.practice.java8features;

//Interface which has only a single abstract method
//Few pre-defined consumer, predicate, BiPredicate, supplier
@FunctionalInterface
public interface CustomFunctionalInterfaces {
	void print();
	default  void printSomething() {
		System.out.println("in default method");
	}

}
