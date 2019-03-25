package learnjava.practice.model;

//We have to implement Cloneable interface in order to copy an object
public class Person implements Cloneable {

	private String fname;
	private String lname;
	private int age;

	public Person() {
	}

	public Person(String fname, String lname) {

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// when you try to print this object you will see classname@HashCode
	// to see desired output when tostring is called
	// we need to Override "toString" method of Object Class
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}

	// for copying object
	// Look for shallow copy vs deep copy --this is how do you want copy content
	// inside object
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
