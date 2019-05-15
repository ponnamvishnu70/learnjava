package learnjava.practice.concurrentcollections;

public class ConcurrencyExample {
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.increment();
		counter.increment();
		counter.increment();
		counter.increment();
	}

}
