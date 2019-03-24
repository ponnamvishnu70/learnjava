package learnjava.practice.classesinterfacesobjects;

//Abstract class can contain implemented methods ,field and 
//method signature(unimplemented methods)
//Abstract class can contain constructors but cannot be instantiated.
//constructors are used for constructor chaining only(calling from concrete classes )
public abstract class AbstractClassExample {
	AbstractClassExample(){
		
	}
	void printsomething() {
	
		System.out.println("implemented method");
	}
	abstract void dosomething() ;
	//http://tutorials.jenkov.com/java/core-concepts.html
}
