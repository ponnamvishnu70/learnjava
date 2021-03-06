package learnjava.practice.springjdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import learnjava.practice.springjdbc.config.Configurations;
import learnjava.practice.springjdbc.dao.HistEodDataDao;

public class MainApp {
	private int i;

	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Configurations.class);
		HistEodDataDao heoddao = ctx.getBean(HistEodDataDao.class);
		List eoddata = heoddao.getHistEodData("MDT");
		//heoddao.insertHistEodData(eoddata);
		heoddao.insertHistEodData2(eoddata);
		//heoddao.getHistEodData2("MU");
		//heoddao.callCompanyheod();
			((AbstractApplicationContext)ctx).close();
		
	}
}
