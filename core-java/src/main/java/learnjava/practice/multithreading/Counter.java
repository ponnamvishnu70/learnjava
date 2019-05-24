package learnjava.practice.multithreading;

public class Counter {
	int i = 0;
	boolean valueChanged= false;
	synchronized void  increment(String threadName) throws InterruptedException {
		i++;
		valueChanged=true;
		//wait() tells the current executing thread(inside synchronized block) to give up the monitor and go to sleep until
		//some other thread will enter the same monitor and calls notify( )
		wait();
		System.out.println(threadName+" --> "+i);
	}

	void doSomething() {
		i++;
		System.out.println("t3 (*****)"+i);
	}
	synchronized  void decrement() {
		if(valueChanged) {
		System.out.println("before decrement "+i);
		i--;
		valueChanged= false;
		//notify() wakes up the first thread that called wait() on the same object
		notify();
		}
	}
}
