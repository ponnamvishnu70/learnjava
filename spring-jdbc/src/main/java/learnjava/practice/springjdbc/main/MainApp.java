package learnjava.practice.springjdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import learnjava.practice.springjdbc.config.Configurations;
import learnjava.practice.springjdbc.dao.HistEodDataDao;

public class MainApp {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configurations.class);
		HistEodDataDao heoddao = ctx.getBean(HistEodDataDao.class);
		List eoddata = heoddao.getHistEodData("MDT");
		//heoddao.insertHistEodData(eoddata);
		//heoddao.insertHistEodData2(eoddata);
		heoddao.getHistEodData2("MU");
		
	}
}
