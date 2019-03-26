package learnjava.practice.loopsconditionaloperators;

public class IfStatementExample {
	public static void main(String[] args) {

		// if(conditonal statement){} conditional statement should return  be either true or false
		// Conditonal statment can be boolean or conditional operators  can be used which
		// result in either true or false
		// == , != , < , > , <= , >=
		boolean flag = false;
		int i = 13;
		int j = 14;
		// different ways we can write if and ifelse

		if (flag) {
			System.out.println("Inside IF 1");
		} else if (!flag) {
			System.out.println("Inside ELSE 1");
		}

		if (flag)
			System.out.println("Inside IF 1");
		else
			System.out.println("Inside IF 2");

		if (!flag) {
			System.out.println("Only if");
		}

		if (i <= j) {
			System.out.println("Conditonal statement is true");
		}

	}
	

}
