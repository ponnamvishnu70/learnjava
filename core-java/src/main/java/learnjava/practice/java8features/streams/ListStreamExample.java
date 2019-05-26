package learnjava.practice.java8features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListStreamExample {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(25);
		l.add(20);
		l.add(18);
		l.add(100);
		l.add(13);
		l.add(5);
		System.out.println(l);
		System.out.println(l.stream().findFirst());// get(0)
		List<Integer> divisibleby5lidt = l.stream()
										  .filter(i -> i % 5 == 0 ? true : false)
										  .collect(Collectors.toList());
		System.out.println(divisibleby5lidt);
		long noofelements = l.stream().map(i->i/5).count();
		List divideby5List = l.stream().map(i->i/5).collect(Collectors.toList());
		System.out.println(divideby5List);
		
		System.out.println(l.stream().sorted().collect(Collectors.toList()));
	}

}
