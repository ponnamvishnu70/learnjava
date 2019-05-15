package learnjava.practice.collections;

import java.util.HashMap;
import java.util.Map;

import learnjava.practice.model.Student;

public class HashCodeEqualsExample {
	public static void main(String[] args) {
		Student s= new Student();
		s.setRank(1);
		Student s1= new Student();
		s.setRank(1);
		Map<Student,String> m = new HashMap<>();
		m.put(s, "1");
		m.put(s1, "1");
		System.out.println(m.size());
		
		
	}

}
