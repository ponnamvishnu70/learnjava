package learnjava.practice.model;

//We have to implement Cloneable interface in order to copy an object
public class Person implements Cloneable, Comparable<Person> {

	private String fname;
	private String lname;
	private int age;
	private int salary;

	public Person() {
	}

	public Person(String fname, String lname) {
		this.fname=fname;
		this.lname=lname;
	}
	public Person(String fname, String lname, int age) {
		this(fname,lname);
		this.age= age;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	// when you try to print this object you will see classname@HashCode
	// to see desired output when tostring is called
	// we need to Override "toString" method of Object Class
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}

	// for copying object
	// Look for shallow copy vs deep copy (this is how do you want copy content
	// inside object)
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person person) {
		return this.age-person.age ;
	}
	
}
