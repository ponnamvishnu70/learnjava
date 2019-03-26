package learnjava.practice.loopsconditionaloperators;

import learnjava.practice.genericsenumsserialization.DayOfWeek;

public class SwitchStatement {
//Switch statement can be used with byte, char, int, short, enum
	public static void main(String[] args) {
		//Switch using int
		int i=8;
		//int i=9;
		switch(i) {
		case 9  :
			System.out.println("in case 9");
			break;
		default :
			System.out.println("in default");
		}
		
		//Switch using String
	 DayOfWeek dow = DayOfWeek.MONDAY;
		switch(dow) {
		case MONDAY:
			System.out.println("monday");
			break;
		}
		
		switch(i) {
		//Multiple cases can have same execution then 
		case 8 :
		case 9  :
			System.out.println("not in default");
			break;
		default :
			System.out.println("in default");
		}
		
	}



}
