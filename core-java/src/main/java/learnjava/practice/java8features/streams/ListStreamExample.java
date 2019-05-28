package learnjava.practice.java8features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		//filter,map,limit,sorted are intermediate operations
		//count,collect are terminal operations
		long noofelements = l.stream().map(i->i/5).count();
		List divideby5List = l.stream().map(i->i/5).collect(Collectors.toList());
		System.out.println(divideby5List);
		
		System.out.println(l.stream().sorted().collect(Collectors.toList()));
		System.out.println(l.stream().limit(1).collect(Collectors.toList()));
		
		Stream.iterate(0, n->n+2)
          .peek(num -> System.out.println("Peeked at:"+num))
          .limit(5)
          .forEach(System.out::println);
		
		List evens = Arrays.asList(2, 4, 6);
		List odds = Arrays.asList(3, 5, 7);
		List primes = Arrays.asList(2, 3, 5, 7, 11);
		//The flatMap() method gives us the ability to flatten a multi-level stream obtained as a result of mapping each element of the input stream to a stream, 
		//and then creating a single stream out of this stream of streams.
		List numbers = (List) Stream.of(evens, odds, primes).flatMap(m->m.stream())						
						.collect(Collectors.toList());
		System.out.println(numbers);
	}

}
