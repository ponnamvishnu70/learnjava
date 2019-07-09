package learnjava.practice.innerclasses;

import java.util.ArrayList;
import java.util.List;

public class AnnonymousInnerClassExample {

	public static void main(String[] args) {
		int x = 48;
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(3);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		doprocess(x, new Process() {

			@Override
			public void processessing(int i) {
				System.out.println(numbers.get(i));
			}

			@Override
			public int getsize() {
				return 10;
			}
		});

	}

	public static void doprocess(int x, Process process) {

		for (int i = 0; i < process.getsize(); i++) {
			process.processessing(i);
		}

	}

}

interface Process {
	// int x= 24;
	void processessing(int i);

	int getsize();
}