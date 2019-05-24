package learnjava.practice.multithreading;

public class LockExample extends Thread{
	
	private CounterUsingLock cl ;
	private String threadName ;
	public LockExample(String threadName, CounterUsingLock cl) {
		this.threadName = threadName;
		this.cl = cl;
		
	}
	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			cl.increment(threadName);
			
		}
	}
	
	public static void main(String[] args) {
		CounterUsingLock	cl = new CounterUsingLock();
		LockExample le = new LockExample("one", cl);
		LockExample le2 = new LockExample("two", cl);
		le.start();
		le2.start();
		
		
	}

}
