package learnjava.practice.java8features;

public class ThisAndClosureExample {
	int i =100;
	Process lambdap = () -> System.out.println("this in a lambda"+this.i);
	
	void testProcessing(int i,Process p){
		System.out.println(p);
		p.processing();
		System.out.println("This is instance variable of ThisAndClosureExample class"+
				ThisAndClosureExample.this.i);
	}
	
	public static void main(String[] args) {
		ThisAndClosureExample tc = new ThisAndClosureExample();
	Process annonymousp = new Process() {
			int i =200;
		public void processing() {
			System.out.println("This is instance variable of Process annonymous class"+this.i);
		}	
		};
		//Below Code will not work.because cannot use this inside a static block
		//Process lambdap = () -> System.out.println("this in a lambda"+this.i);
				
		
	tc.testProcessing(tc.i,annonymousp);	
	tc.testProcessing(tc.i,tc.lambdap);	
		
	}

}

interface Process{
	void processing();
}
