package learnjava.practice.test;

import org.apache.commons.lang3.math.NumberUtils;

public class AppTest {
	public static void main(String[] args) throws InterruptedException {
		long starTime = System.currentTimeMillis();
		Thread.sleep(5670); 
		long endTime = System.currentTimeMillis();
		long time = endTime-starTime;
		double f = (double)time /(double)1000;
		System.out.println(f+"secs");
		String[] s ="APPL.CSV".split("\\.");
	System.out.println(	s[0]);
	System.out.println(NumberUtils.isNumber("    "));
	}

}
