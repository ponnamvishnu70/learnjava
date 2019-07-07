package learnjava.practice.springaop.service;

import org.springframework.stereotype.Service;

import learnjava.practice.springaop.customannotations.Loggable;

@Service
public class CarService {

	private int year;
	private String make;
	private String model;

	public boolean tirereplacement() {
		return true;

	}
	@Loggable
	public boolean oilchange() {
		return true;
	}

	public boolean brakefuildchange() {
		if(true)
		throw new RuntimeException("something went wrong ");
		return true;
	}

	public boolean wipersreplacement() {
		return true;
	}

	public int getYear() {
		return year;
	}
	@Loggable
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
