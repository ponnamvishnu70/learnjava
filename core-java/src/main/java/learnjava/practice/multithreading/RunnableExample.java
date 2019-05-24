package learnjava.practice.multithreading;
//If extend thread class we cannot extend any other class (No Multiple Inheritance)
public class RunnableExample  implements Runnable{

	@Override
	public void run() {
	System.out.println("inside run method in runnable");
		
	}
	
	public static void main(String[] args) {
		RunnableExample re = new RunnableExample();
		Thread t= new Thread(re);
		t.start();
	}

}
