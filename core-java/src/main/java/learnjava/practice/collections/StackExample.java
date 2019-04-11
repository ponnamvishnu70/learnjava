package learnjava.practice.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
//LIFO principle
//java util stack eventually extends List
//Try to use push pop search instead of add get/delete contains(make more sense readability)
public class StackExample {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
			stack.add("vishnu");
			stack.add("ponnam");
			stack.add("ponnam123");
			stack.push("vishnu456123789");
			//Removes and returns the object that is on the top of the stack
			System.out.println(stack.pop());
			//just return the element that is on the top of the stack--(No Remove)
			System.out.println(stack.peek());
			
			Iterator<String> namesstack = stack.iterator();
			stack.forEach(s->System.out.println(s));
			List<String> stacklist = new Stack<String>();
			
	}

}
