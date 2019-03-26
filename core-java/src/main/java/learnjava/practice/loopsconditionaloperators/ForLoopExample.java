package learnjava.practice.loopsconditionaloperators;

import java.util.Arrays;

public class ForLoopExample {
	public static void main(String[] args) {
		for(int i = 0 ; i<10 ; i++) {
			System.out.println("looping int" + i);
		}
		
		String[] strings= {"Apple","orange","banana"};
		Arrays.asList(strings);
		for (String s:Arrays.asList(strings)) {
			System.out.println(s);
		}
		
		for(int i = 0 ; i<10 ; i++) {
			if(i==4||i==5) {
				//when continue command is encountered JVM skips this 
				//iteration(without executing reminder of the body) 
				// moves on to next iteration 
				continue;
			}
			if(i==7) {
				//when break command is encountered JVM will jump out of this iteration
				break;
			}
			
			System.out.println("looping int" + i);
		}
	}

}
