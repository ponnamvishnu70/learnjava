package learnjava.practice.multithreading;

public class PrintJob  implements Runnable{

	String name;
	public PrintJob(String name) {
		this.name=name;	
	}
	
	@Override
	public void run() {
		System.out.println(name + " print job started by thread "+ Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			
		}
		System.out.println(name + " print job completed by thread "+ Thread.currentThread().getName());
	}

}

