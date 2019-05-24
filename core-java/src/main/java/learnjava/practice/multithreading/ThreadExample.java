package learnjava.practice.multithreading;

public class ThreadExample extends Thread {
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("In another Thread");
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadExample ex = new ThreadExample();
		ex.start();
		ex.join();
		System.out.println("In main thread");
	}

}
