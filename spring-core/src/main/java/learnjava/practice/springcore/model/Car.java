package learnjava.practice.springcore.model;

import org.springframework.beans.factory.annotation.Required;

public class Car {
	private int mileage;
	private String make;
	private String model;
	
	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getMake() {
		return make;
	}
	@Required
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	

}
