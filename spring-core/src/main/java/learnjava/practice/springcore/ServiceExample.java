package learnjava.practice.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceExample {
	//@autowired - on field is by default check for beans byType
	//by default @Autowired(required = true). if the field is not a mandatory field we make @Autowired(required = false)
	@Autowired
	@Qualifier("serviceDao2")
	private ServiceDao dao;	
	
	/*@Autowired--on constructor dao will be injected during constructor dependency injection
	ServiceExample(ServiceDao dao){
		this.dao=dao;
	}*/
	
	public void Process(){
		System.out.println(dao.getSomething());
	}
	
	public ServiceDao getDao() {
		return dao;
	}
	//@Autowired -- on setter methods
	public void setDao(ServiceDao dao) {
		this.dao = dao;
	}

}
