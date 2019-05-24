package learnjava.practice.multithreading;

import java.util.concurrent.Callable;

public class AddJob implements Callable<Integer> {
	int i;
	public AddJob(int i) {
	this.i = i;
	}

	@Override
	public Integer call() throws Exception {
		int temp=0;
		for(int j=0; j<=i; j++) {
			temp=temp+j;
		}
		return temp;
	}

	

}
