package learnjava.practice.ocjp8practice;

public class DowhileTest {
		public static void main(String[] args) {
			int i = 1;
			do {				
				System.out.print(i++ + "");
			} while (i <= 5);//if i is inside do then it will cause compilation error.Scope of i not visible
		}
	
}
