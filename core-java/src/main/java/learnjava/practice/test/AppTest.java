package learnjava.practice.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

public class AppTest {
	public static final String WHITE_SPACE_1 = " ";
	public static final String WHITE_SPACE_9 = "         ";
	public static final String WHITE_SPACE_17 = "                 ";
	public static final String WHITE_SPACE_45 = "                                             ";
	public static void main(String[] args) throws InterruptedException {
		System.out.println(calculateQtrYr("3", "2019"));
	}
	
	
	public static String greet() {
		String str="vishnu";
		if(str.equals("vishnu")){
			throw new StringIndexOutOfBoundsException();	
		}
		
		return "";
	}
	
	
	public  static boolean calculateQtrYr(String qtr, String year) {
		
		Calendar cal = Calendar.getInstance();
		
		int currentQtr = (cal.get(cal.MONTH))/3 + 1;
		int currentYear = cal.get(cal.YEAR);
		String currentProcessingQtr = currentQtr+""+currentYear;
		String reportQtrYear =qtr+year;
		if(Integer.valueOf(currentProcessingQtr)<Integer.valueOf(reportQtrYear)) {
			return true;
		}
		
		return false;
	}
	
	public static  Date getLastdayOfQtrYr(String qtr, String year) {
		Date dt= null;
		Short qt = Short.parseShort(qtr);

			switch (qt){
				case 1 :{
						dt=new Date("03/31/"+ year);
						break;
					}
				case 2 :{
						dt=new Date("06/30/"+ year);
						break;
					}
				case 3: {
					dt=new Date("09/30/"+ year);
					break;
				}
				case 4:{
					 dt= new Date("12/31/"+ year);
					break;
				}
			}

			return dt;
			
	}

}
