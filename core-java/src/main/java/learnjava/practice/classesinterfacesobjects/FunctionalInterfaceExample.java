package learnjava.practice.classesinterfacesobjects;

//A functional interface, introduced in Java 8,
//is an interface which has only a single abstract method.
//Conversely, if you have any interface which has only a single abstract method, 
//then that will effectively be a functional interface

//One of the most important uses of Functional Interfaces is that 
//implementations of their abstract method can be passed around as Lambda Expressions. 
//By virtue of their ability to pass around functionality(i.e. behavior),
//functional interfaces primarily enable behavior parameterization.

//@FunctionalInterface annotation can be used to explicitly specify 
//that a given interface is to be treated as a functional interface. 
//Then the compiler would check and give a compile-time error in case 
//the annotated interface does not satisfy the basic condition of qualifying
//as a functional interface(that of having a single abstract method)

@FunctionalInterface
public interface FunctionalInterfaceExample {
	void singleMethod();
}
