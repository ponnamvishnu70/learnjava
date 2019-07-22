package learnjava.practice.jms.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 2737742148046098035L;
	private int age;
	private String fname;
	private String lname;
	private String email;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
