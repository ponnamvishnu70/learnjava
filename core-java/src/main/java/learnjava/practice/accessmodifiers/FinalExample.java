package learnjava.practice.accessmodifiers;

//Final on class level mean NO SUBCLASS for this class can be created
public final class FinalExample {
	/*****Final Variable - START*********/

	//Final variable once initialized cannot be modified
	//final variable can only  be initiated during declaration or in the constructor
	final int i ;
	final int j=10;
	final String name="vishnu";
	
	public FinalExample() {
		i=10;
	}
	
	void changefinalvariables(){
		//i=20;
		//name="vish"; compile time error because they are final, can't be modified
	}
	/*****Final Variable - END*********/
	/*****Final Method - START*********/
	//Final method on method signature mean NO OVERRIDING
	public final void changeName() {
	   
	   }
	
	/*****Final Method - END*********/
}
