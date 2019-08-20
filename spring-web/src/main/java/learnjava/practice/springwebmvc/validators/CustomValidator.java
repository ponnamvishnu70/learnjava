package learnjava.practice.springwebmvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import learnjava.practice.springweb.model.Person;
import learnjava.practice.springweb.model.Student;

public class CustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {		
		return Person.class.equals(clazz) || Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof Person) {
		Person p = (Person)target;
		System.out.println("validating person");
		if(!p.getFname().equals("vishnu")) {
			errors.reject("05");
			
		}
		}
		
		if(target instanceof Student) {
			Student p = (Student)target;
			System.out.println("validating student");
			if(!p.getLname().equals("ponnam")) {
				errors.reject("05");
				
			}
			}
		
		
	}

}
