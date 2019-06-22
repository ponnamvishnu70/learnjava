package learnjava.practice.springcore.model;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Required;

public class Student {

	private String name;
	private int age;
	
	private List<String> subjects;

	public Student() {
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@PostConstruct
	public void init() {
		System.out.println("bean instantiated and doing any setup activities");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("bean destroyed  and clean up activities");
	}

	public String getName() {
		return name;
	}
	//@Required -- when this annotation is used we have to use only setter DI for bean creation
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	//@Required -- when this annotation is used we have to use only setter DI for bean creation
	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

}
