package learnjava.practice.multithreading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Callable vs runnable : run(Runnable) method doesn't return anything. 
//But with call(Callable) we can return a value
public class CallableExecutorExample{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AddJob[] job = {
			new AddJob(2),
			new AddJob(3),
			new AddJob(4)
			
		};
		
		
	ExecutorService es = Executors.newFixedThreadPool(3);
	Map<AddJob,Integer> jobresults = new HashMap<AddJob,Integer>();
	for(AddJob addJob :job) {
		Future<Integer> f = es.submit(addJob);
		System.out.println("sum of first "+addJob.i +"  digits is  "+f.get());
		jobresults.put(addJob, f.get());
		
	}
	
	System.out.println(jobresults);
	es.shutdown();
		
	}
	
}
