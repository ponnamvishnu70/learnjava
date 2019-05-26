package learnjava.practice.java8features;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredefinedFunctionalInterfaceExample {
	public static void main(String[] args) {
		//Predicate is predefined FUnctional Interface in introduced in java 8
		// has only one methof test(T t) return a boolean value
		Predicate<Integer> predicate = i-> i%2 == 0 ? true : false;
		Predicate<Integer> predicategtten = i-> i>10 ? true : false;
		 System.out.println(predicate.test(13));
		 System.out.println(predicate.negate().test(13));
		 Predicate<Integer> joinAndPredicate = predicate.and(predicategtten);
		 Predicate<Integer> joinOrPredicate = predicate.and(predicategtten);
		 System.out.println("check whether both the predicates are true "+ joinAndPredicate.test(14));
		 System.out.println("check whether one of the predicates is true "+ joinOrPredicate.test(13));
		 System.out.println("-------------------------------");
		 Function function = t->"vishnu";
		 System.out.println("function apply return "+ function.apply("ponnam"));
		 Function<String, Integer> function1 = t->t.length();
		 System.out.println("function apply return length of string passed "+ function1.apply("vishnu ponnam"));
		 
		 
		 
		 
		 
		
		}
				

}
