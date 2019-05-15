package learnjava.practice.generics;

public class GenericsExample {

public static void main(String[] args) {
	Test<String,Integer> t = new Test<String,Integer>("s");
	System.out.println(t.getInstance());
	t.obj="y";
	//Compile Time error. Because Test instance is created with <String> type. 
	//This instance can only hold string values
	//t.obj=new Integer(12);
	t.printClassNames(15);
}
}
