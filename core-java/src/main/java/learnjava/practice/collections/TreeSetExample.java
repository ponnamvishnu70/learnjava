package learnjava.practice.collections;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import learnjava.practice.model.Person;

public class TreeSetExample {
	public static void main(String[] args) {
		NavigableSet<Integer> nums = new TreeSet<Integer>();
		nums.add(100);
		nums.add(200);
		nums.add(300);
		nums.add(400);
		nums.add(500);
		nums.add(600);
		System.out.println(nums);
		
		
	}

}
