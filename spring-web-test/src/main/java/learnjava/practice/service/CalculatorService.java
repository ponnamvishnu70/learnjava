package learnjava.practice.service;

import learnjava.practice.data.SomeData;

public class CalculatorService {
	
	SomeData someData;
	
 public void setSomeData(SomeData someData) {
		this.someData = someData;
	}

public   int sum(){
	   int sum =0;
	   for(int value : someData.getData()) {
		   sum = sum + value;
	   }
	
	   return sum;
   }

}