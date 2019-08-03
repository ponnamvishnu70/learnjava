package learnjava.practice.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

public class AppTest {
	public static final String WHITE_SPACE_1 = " ";
	public static final String WHITE_SPACE_9 = "         ";
	public static final String WHITE_SPACE_17 = "                 ";
	public static final String WHITE_SPACE_45 = "                                             ";
	public static void main(String[] args) throws InterruptedException {
		long starTime = System.currentTimeMillis();
		Thread.sleep(5670);
		long endTime = System.currentTimeMillis();
		long time = endTime - starTime;
		double f = (double) time / (double) 1000;
		System.out.println(f + "secs");
		String[] s = "APPL.CSV".split("\\.");
		System.out.println(s[0]);
		System.out.println(NumberUtils.isNumber("    "));

		List<TaxInfo> list = new ArrayList<TaxInfo>();
		for (int i = 0; i < 10; i++) {
			TaxInfo e = new TaxInfo();
			e.setEmployerName("name" + i);
			e.setEmployerNum("123" + 1);
			list.add(e);
		}
		
		try {
			List<String> strl = new ArrayList<>();
			strl.add(greet());
		}catch (Exception e) {
			System.out.println("inside exception");
		}
		
	}
	
	
	public static String greet() {
		String str="vishnu";
		if(str.equals("vishnu")){
			throw new StringIndexOutOfBoundsException();	
		}
		
		return "";
	}

}
