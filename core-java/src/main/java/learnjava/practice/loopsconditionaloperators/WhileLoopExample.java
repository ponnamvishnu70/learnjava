package learnjava.practice.loopsconditionaloperators;

public class WhileLoopExample {
	public static void main(String[] args) {
		int counter = 0;
		//While Loop
		while (counter < 10) {
			System.out.println("count " + counter);
			if(counter==4||counter==5) {
				//when continue command is encountered JVM skips this 
				//iteration(without executing reminder of the body) 
				// moves on to next iteration 
				counter++;
				continue;
			}
			if(counter==7) {
				//when break command is encountered JVM will jump out of this iteration
				break;
			}
			counter++;
			
		}
		
		//do while
		// the code inside do is executed at least once irrespective of while condition
		// and executed repeatedly until while loop condition is true
		do {
			System.out.println("in do while loop");
		} while (counter<0);
	}

}
