package learnjava.practice.springweb.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;

public class Student {
	
	private String lname;
	@Min(value=8)
	private String fname;
	private int age;
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	public Student() {}
	
	public Student(String lname, String fname, int age) {
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
