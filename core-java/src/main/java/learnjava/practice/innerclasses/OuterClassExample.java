package learnjava.practice.innerclasses;

public class OuterClassExample {
	
	public class InnerClass{
		
		public void doSomethingInnerclass() {
			System.out.println("inside inner class");
		}
	}
	public static  class StaticInnerClass {
		static int i=10;
		static {
			System.out.println("Hello from StaticInnerClass");
		}
		
	}
	
	public static void main(String[] args) {
		OuterClassExample oc = new OuterClassExample();
		InnerClass ic = oc.new  InnerClass();
		ic.doSomethingInnerclass();
		int k = OuterClassExample.StaticInnerClass.i;
		
	}

}
