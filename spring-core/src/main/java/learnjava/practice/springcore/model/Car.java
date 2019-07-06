package learnjava.practice.springcore.model;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import learnjava.practice.springcore.eventlistener.MyEvent;

public class Car implements ApplicationEventPublisherAware{
	private int mileage;
	private String make;
	private String model;
	ApplicationEventPublisher applicationEventPublisher;
	
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
	
	public void drive() {
		System.out.println("i am driving car");
		MyEvent me = new MyEvent(this);
		applicationEventPublisher.publishEvent(me);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
