package learnjava.practice.classesinterfacesobjects;

import learnjava.practice.model.Person;

//Object Class in Java
//Object class is parent class of all the other java classes directly or indirectly.
//So, Object method are available to all the classes  
public class ObjectClassTest implements Cloneable{
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p = new Person("vishnu", "ponnam");
		Person person = new Person("vishnu", "ponnam");
		Person person1= (Person)p.clone();
		p.setLname("ponnam-original copy");
		person1.setFname("vishnu-shallow copy");
		System.out.println(p.toString());
		System.out.println(person1.toString());
		
		System.out.println(p.toString());//this method is Object class and we have overridden it
		System.out.println(p.hashCode());//Returns a hash code value for the object
		System.out.println("shallow copy"+person1.hashCode());
		//Results false because we comparing address not the content in it
		//we need to override equals in person class 
		//how the person class should be compared
		System.out.println(p.equals(person)); 
		Class cperson = p.getClass();
		System.out.println(cperson.getName());
		//finalize() method : This method is called just before an object
		//is garbage collected. It is called by the Garbage Collector on an object 
		//when garbage collector determines that there are no more references to the object
	}

}
