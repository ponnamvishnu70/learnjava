package learnjava.practice.generics;

public class Test<T, U> {

	T obj;

	Test(T obj) {
		this.obj = obj;
	}

	public T getInstance() {
		return obj;
	}
	
	 void printClassNames(U uobj){
		 System.out.println(uobj.getClass().getName());
	}

}
