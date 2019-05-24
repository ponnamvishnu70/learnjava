package learnjava.practice.multithreading;

public class ThreadLocalExample {
	
	public static void main(String[] args) {
	//The ThreadLocal class in Java enables you to 
	//create variables that can only be read and written by the same thread
		ThreadLocal<String> tl = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
			
				return "vishnu";
			}
		};
		
		System.out.println(tl.get());
		tl.remove();
		//Returns the value in the current thread's copy of this thread-local variable.
		//If the variable has no value for the current thread, it is first initialized to the 
		//value returned by an invocation of the initialValue method.
		System.out.println(tl.get());
		tl.set("ponnam");
		System.out.println(tl.get());
	}

}
