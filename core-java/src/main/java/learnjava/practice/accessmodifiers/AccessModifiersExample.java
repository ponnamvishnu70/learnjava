package learnjava.practice.accessmodifiers;

//public - visibility to everyone
//default -  if no keyword/access modifier is mentioned ,Then it is default. Visibility is to the package
//private - visibility only to that class
//protected - visibility to package and subclasses


//class can only have "public" and "default"
// class AccessModifiersExample { --> default
public class AccessModifiersExample {
	
	/*******AccessModifiers variables - START*******/
	public int x;//visibity to every one 
	int y; // this is default
	private int z; // as this is not visible to other classes if we have to set or get this  
	//variable outside this class we need to provide setter and getter methods
	protected int i;//visibility to package and subclasses

	
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	/*******variables - END*******/
	
	/*******AccessModifiers Method - START*******/
	//we can apply all access modifiers on methods
	public void doSomething() {
	//	only final is permitted on method varibles 
		//method level variable will be created and destroyed outside this method so no access specifiers
		//public int i=1; --> Compilation error 
		int i=0;
	}
	/*******AccessModifiers method - END*******/

}
