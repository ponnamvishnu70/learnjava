package learnjava.practice.multithreading;

public class ParentThread extends Thread {
	//Statically binded 
	static ThreadLocal<String> t = new ThreadLocal<String>() {
		protected String initialValue() {
			return "ponnam";
		}

	};
	static InheritableThreadLocal<String> it = new InheritableThreadLocal<String>() {
		protected String initialValue() {
			return "it-ponnam";
		}

	};
	
	
	
	@Override
	public void run() {		
		t.set("vishnu");//Modified the value in t for parent thread still will not be visible for child thread
		it.set("it-vishnu");
		ChildThread c = new ChildThread();
		c.start();
	}

}
