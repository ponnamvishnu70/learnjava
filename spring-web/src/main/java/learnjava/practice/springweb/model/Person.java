package learnjava.practice.springweb.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
	@NotNull
	@Size(min=2 , max =10)
	private String lname;
	//@JsonInclude(Include.NON_NULL)
	//@JsonProperty("first_name")	
	private String fname;
	private int age;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	public Person() {}
	
	public Person(String lname, String fname, int age) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.age = age;
	}

	
	public String getLname() {
		return lname;
	}

	public String getFname() {
		return fname;
	}

	public int getAge() {
		return age;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


}
