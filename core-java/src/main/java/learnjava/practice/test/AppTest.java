package learnjava.practice.test;

public class AppTest {
	public static void main(String[] args) throws InterruptedException {
		long starTime = System.currentTimeMillis();
		Thread.sleep(5670); 
		long endTime = System.currentTimeMillis();
		long time = endTime-starTime;
		double f = (double)time /(double)1000;
		System.out.println(f+"secs");
	}

}
