package learnjava.practice.classesinterfacesobjects;

//Interface can only contain method "signature and fields"
//cannot create instances of a Java interface by itself
//Interface are declared using keyword interface
//Interface can only have "public" and "default"(package scope no access modifier scenario)
//Interface can  extend  multiple interfaces
public interface InterfaceExample {
	
	//Interface variables are static because Java interfaces cannot be instantiated
	//Interface variables are final
	//Static and final keywords will be added by compiler
	public  int I=10;
	
	//Interface method are by default "public and  abstract"
	//"public and  abstract" keywords will be added by compiler(check .class)
	void dosomething();
	
	//Since java 8 this is possible you can write default methods with Implementation. 
	//This helps in adding new method to interface without breaking client 
	//code(Otherwise all the classes implementing this Interface need to provide implementation for this method)
	//classes implementing this method can override to change the behavior
	//Don't confuse default access modifier with default method in interface
	//Default method can't be final...Please see reason below
	default void somethingelse() {
		 System.out.print("Default method");
	}
	
	//Static method should have implementation
	//Static are same as Static methods in class
	static void print(){
		 System.out.print("Static method");
	}
	
	/* Default method should not be final
	 *
	 *Ans from 
	 *https://stackoverflow.com/questions/23453287/why-is-final-not-allowed-in-java-8-interface-methods
	 *
	 * interface A { default void foo() { ... } }
	 * 
	 * interface B { }
	 * 
	 * class C implements A, B { } Here, everything is good; C inherits foo() from
	 * A. Now supposing B is changed to have a foo method, with a default:
	 * 
	 * interface B { default void foo() { ... } } 
	 * 
	 * Now, when we go to recompile C,
	 * the compiler will tell us that it doesn't know what behavior to inherit for
	 * foo(), so C has to override it (and could choose to delegate to A.super.foo()
	 * if it wanted to retain the same behavior.) 
	 * 
	 * But what if B had made its default
	 * final, and A is not under the control of the author of C? Now C is
	 * irretrievably broken; it can't compile without overriding foo(), but it can't
	 * override foo() if it was final in B.
	 * 
	 */

}
