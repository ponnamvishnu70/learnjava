package learnjava.practice.ocjp8practice;

public class Test {
	static String o = "";

	public static void main(String[] args) {
		 z: for (int x = 3; x < 8; x++) {
			 System.out.println("befor 4");
			if (x == 4)
		continue;
			System.out.println("after"+x); 
					
			if (x == 4)
				break ;
			o += x;
		}
		System.out.println(o);
		Character ch = new Character('a'); 
		System.out.print(Character.isLetterOrDigit(ch)); 
	for(;;) {
		System.out.println("vvvv");
	}
	}
}
