package learnjava.practice.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassObjectExample {
	public static void main(String[] args) throws ClassNotFoundException {
		//Loaded class file and created class class object in heap area
		Class c = Class.forName("learnjava.practice.misc.Employee");
		Field[] f = c.getDeclaredFields();
		Method[] m = c.getDeclaredMethods();
		System.out.println(f.length);
		System.out.println(f[0]);
		System.out.println(m.length);
		System.out.println(m[0]);
		Class cstring = Class.forName("java.lang.String");
		Field[] fstr = cstring.getDeclaredFields();
		Method[] mstr = cstring.getDeclaredMethods();
		System.out.println(fstr.length);
		System.out.println(fstr[0]);
		System.out.println(mstr.length);
		System.out.println(mstr[0]);
		Employee e = new Employee();
		Class c2 = e.getClass();
		System.out.println(c2.hashCode());
		Employee e1 = new Employee();
		Class c3 = e1.getClass();
		System.out.println(c3.hashCode());
		
	}

}
