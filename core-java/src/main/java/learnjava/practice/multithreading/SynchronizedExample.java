package learnjava.practice.multithreading;

public class SynchronizedExample extends Thread{
	
	private Counter counter;
	private String threadName;

	public SynchronizedExample(String t, Counter c) {
	this.threadName = t;
	this.counter= c;
	}
	 @Override
	public void run() {
		// Call non synchronized method 
		 //To check whether non synchronized can be called concurrently 
		 //when lock is acquired by synchronized
		 //They will be executed concurrently
		 if(threadName.equals("t3")) {
			 for(int j=0; j<100;j++) {
				// counter.doSomething();
			 }
			 
		 }else if(threadName.equalsIgnoreCase("t2")){

			 for(int j=0; j<10;j++) {				 
				 counter.decrement();
			 }
		 
			 
		 }else {
		 for(int j=0; j<10;j++) {
			 
		try {
			counter.increment(threadName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 }
	 }
	 }
	 public static void main(String[] args) throws InterruptedException {
		 Counter c = new Counter();
		 //Two thread are working on same instance of counter
		 //and trying to increment same variable of the counter instance
		 Thread threadone  = new SynchronizedExample("t1",c);
		 Thread threadtwo  = new SynchronizedExample("t2",c);
		 Thread threadthree  = new SynchronizedExample("t3",c);
		 
		 threadone.start();
		// The join method allows one thread to wait for the completion of another.
		 //If t is a Thread object whose thread is currently executing,
		// t.join();
		 //causes the current thread to pause execution until t's thread terminates
		 threadone.join();
		 threadtwo.start();
		 threadtwo.join();		 
		 threadthree.start();
		 threadthree.join();
		
	}

}
