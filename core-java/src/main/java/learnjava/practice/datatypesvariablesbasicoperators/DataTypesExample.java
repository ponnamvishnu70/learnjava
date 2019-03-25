package learnjava.practice.datatypesvariablesbasicoperators;


//Primitive Datatypes
public class DataTypesExample {

	public static void main(String[] args) {	
		//boolean is datatype for storing binary value of true or false
		boolean booleasn = false;
		//char is datatype for storing single character 
		char	c='v';
		//Number datatype with  can hold from -128 to 127
		byte b= -128;
		//Number datatype, values from -32.768 to 32.767
		short s =0;
		//Number datatype, values from -2.147.483.648 to 2.147.483.647
		int	i = 0;
		//Number datatype, values from -9.223.372.036.854.775.808 to 9.223.372.036.854.775.808
		long l = 0;
		//float and decimal Number Datatypes ,with decimal points or fractions
		float f= 1.23f;
		double d =0.00;
		
		//Why should BigDecimal be used for floating pointing operations?
		System.out.println(11.8-11.2);
		//should return .6 but will return 0.6000000000000014 which not accurate use bigdecimal for floating point accuracy
			
		/* 1. 
		 * Use BigDecimal instead of float/double during floating-point arithmetics in java.
		 * Because java can't handle floating points precisely
		 * 2.
		 * Do not use == or != as a floating-point comparison. use
		 * Float.floatToIntBits (float) or Double.doubleToLongBits (double) instead. 
		 * Using == or != might end up in infinite loop
		 */
		
		//DOUBLE vs FLOAT
		/*
		 * *Though both float and double datatype are used to represent
		 *  floating point numbers in Java, a double data type is more precise
		 *  than float. A double variable can provide precision up to 15 to 16
		 *  decimal points as compared to float precision of 6 to 7 decimal digits.
		 *  Another significant difference between float and double is their 
		 *  storage requirement, double is more expensive than float. 
		 *  It takes 8 bytes to store a variable while float just takes 4 bytes. 
		 *  Which means, if memory is constraint than its better to use float than 
		 *  double. BTW, the double type also has larger range than float and if your 
		 *  numbers don't fit well in float then you have to use double in Java. 
		 *  It's also worth noting that floating point numbers or real numbers are by 
		 *  default double in Java. If you want to store them into float variable,
		 *   you need to either cast them or use a prefix 'f' or 'F' as shown in our  example
		 */
		 
		
	}

}
