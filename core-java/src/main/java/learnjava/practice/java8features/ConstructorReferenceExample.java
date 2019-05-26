package learnjava.practice.java8features;

public class ConstructorReferenceExample {
	
	public static void main(String[] args) {
		GetInstanceFucntionalInterface<Test> testInstance = ()->new Test();
		Test t=testInstance.getInstance();
		//Constructor Reference
		GetInstanceFucntionalInterface<Test> testInstance2 =Test::new;
		testInstance2.getInstance();
		
	}

	
}
