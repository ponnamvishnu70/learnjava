package learnjava.practice.innerclasses;

public class OuterClassExample {
	
	public class InnerClass{
		public void doSomethingInnerclass() {
			System.out.println("inside inner class");
		}
	}
	
	public static void main(String[] args) {
		OuterClassExample oc = new OuterClassExample();
		InnerClass ic = oc.new  InnerClass();
		ic.doSomethingInnerclass();
		
	}

}
