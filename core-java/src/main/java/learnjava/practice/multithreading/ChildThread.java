package learnjava.practice.multithreading;

public class ChildThread extends Thread {

	@Override
	public void run() {
		
		//intialvalue which is statically bounded is displayed even though
		//value in thread local is changed by parent thread as we are using ThreadLocal
		System.out.println("from child thread"+ParentThread.t.get());

		//changed value is visible here because we are using inheritedthreadlocal
		System.out.println("from child thread"+ParentThread.it.get());
	}
}

