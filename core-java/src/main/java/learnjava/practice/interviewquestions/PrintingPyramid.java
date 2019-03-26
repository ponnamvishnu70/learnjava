package learnjava.practice.interviewquestions;

public class PrintingPyramid {

	static void printPyramid(int height) {
		if (height > 0) {
			for (int i = 1; i < height + 1; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println("");

			}

		}
	}

	public static void printPyramid180rotated(int height) {
		for (int i = 0; i < height; i++) {
			for (int j = height - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	public static void printTriagle(int height) {
		for (int i = 0; i < height; i++) {
			for (int j = height - i; j > 1; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		printTriagle(10);
	}

}
