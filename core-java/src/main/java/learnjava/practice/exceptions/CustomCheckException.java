package learnjava.practice.exceptions;


//Throw to explicitly throw a new exception --> throw new Exception();
//Throws is used in method signature. 
//It says the this method is not handling following exception caller should handle it.
public class CustomCheckException extends Exception {
	public CustomCheckException(String s) {
	super(s);
	}

}
