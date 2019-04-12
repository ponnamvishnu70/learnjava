package learnjava.practice.collections;

import java.util.PriorityQueue;

import learnjava.practice.model.Person;
//FIFO principle
//Based on the priority the element will be placed in the Queue
//The what ever object that we add into priority queue should implement
//Comparable interface and implement compare method
public class PriorityQueueExample {

	public static void main(String[] args) {
	 PriorityQueue<String> pqueue = new PriorityQueue<String>();
	 pqueue.add("msg7");
	 pqueue.add("msg8");
	 pqueue.add("msg1");
	 pqueue.add("msg4");
	 System.out.println(pqueue.peek());//return highest priority element
	 System.out.println(pqueue.poll());//remove and return highest priority element
	 pqueue.forEach(s->System.out.println(s));
	 PriorityQueue<Person> priorityperson = new PriorityQueue<Person>();
	 priorityperson.add(new Person("pujara", "cheteswar",28));
	 priorityperson.add(new Person("brad", "hogg",35));
	 priorityperson.add(new Person("radhid", "khan",25));
	 priorityperson.add(new Person("virat", "kohli",29));	
	 //priorityperson.forEach(s->System.out.println(s));
	 for(int i=0; i <priorityperson.size();i++) {
        // System.out.println(priorityperson.peek());
     }
	 priorityperson.add(new Person("prithvi", "shaw",19));
	 int size=priorityperson.size();
	 for(int i=0; i <size;i++) {
         System.out.println(priorityperson.poll());
         if(i==0) {
        	 
         }
     }
	}
}
