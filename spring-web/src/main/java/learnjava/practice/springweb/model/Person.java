package learnjava.practice.springweb.model;

public class Person {

	private String lname;
	private String fname;
	private int age;
	
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


}
