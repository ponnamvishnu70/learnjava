package learnjava.practice.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterUsingLock {
	
	int i =0;
	Lock l = new  ReentrantLock();
	void increment(String threadName){
		l.lock();
		i++;
		System.out.println(threadName+" --> " + i);
		l.unlock();
	}


}
