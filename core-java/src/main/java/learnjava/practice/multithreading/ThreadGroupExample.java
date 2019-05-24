package learnjava.practice.multithreading;

public class ThreadGroupExample {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getStackTrace());
		System.out.println(Thread.currentThread().getThreadGroup());
	}

}
