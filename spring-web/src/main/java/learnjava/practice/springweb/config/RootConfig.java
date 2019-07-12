package learnjava.practice.springweb.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "learnjava.practice" })
public class RootConfig {

	//jndi datasource jndi name jdbc/dsstocktrading
	//this is configure in server.xml in tomcat under GlobalNamingResources with child tag resource
	//ResourceLink tag is used in context.xml for linking resources to context
	//below is one way of getting datasource by looking up in the context
	//2nd way of getting is dataSource bean is adding below lines of code in spring beans file
	//<jee:jndi-lookup id="dataSource"
		//jndi-name="jdbc/dsstocktrading"
		//	expected-type="javax.sql.DataSource" />
	@Bean
	public DataSource dataSource() {
		System.out.println("creating data source bean");
		DataSource ds = null;
		try {
			InitialContext ictx = new InitialContext();
			Context envContext = (Context) ictx.lookup("java:comp/env");
			ds = (DataSource) envContext.lookup("jdbc/dsstocktrading");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		System.out.println("creating JdbcTemplate bean");
		return new JdbcTemplate(dataSource());
	}


}
