package learnjava.practice.springjdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learnjava.practice.springjdbc.config.Configurations;
import learnjava.practice.springjdbc.dao.HistEodDataDao;

public class MainApp {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configurations.class);
		ctx.getBean(HistEodDataDao.class).insertHistEodData();
		
	}
}
