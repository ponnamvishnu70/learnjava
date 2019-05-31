package learnjava.practice.ocjp8practice;

import java.util.Arrays;

public class TwoDimensionalArraySortExample {
	
	public static void main(String[] args) {
		String[][] str = {{"A","Z"},{"V","P","C"},{"X","B","Q"}};
	//Write logic to sort 2d array
		Arrays.sort(str, (s1,s2)->{return 1;});
		
	}

}
