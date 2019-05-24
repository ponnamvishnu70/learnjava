package learnjava.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample{
	public static void main(String[] args) {
		PrintJob[] job = {
			new PrintJob("vishnu"),
			new PrintJob("ponnam"),
			new PrintJob("vishnu1"),
			new PrintJob("ponnam1"),
			new PrintJob("vishnu2"),
			new PrintJob("ponnam2")
		};
		
		
		ExecutorService es = Executors.newFixedThreadPool(3);
	for(PrintJob printjob :job) {
		es.submit(printjob);
	}
	es.shutdown();
		
	}
	
}
