package learnjava.practice.collections;

import java.util.PriorityQueue;
//FIFO principle
public class PriorityQueueExample {

	public static void main(String[] args) {
	 PriorityQueue<String> pqueue = new PriorityQueue<String>();
	 pqueue.add("msg1");
	 pqueue.add("msg2");
	 pqueue.add("msg3");
	 pqueue.add("msg4");
	 System.out.println(pqueue.peek());//return first element
	 System.out.println(pqueue.poll());//remove and returned
	 pqueue.forEach(s->System.out.println(s));
	}
}
