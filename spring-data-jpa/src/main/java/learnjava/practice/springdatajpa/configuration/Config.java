package learnjava.practice.springdatajpa.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "file:C:/properties/application.properties" })
@ComponentScan(basePackages = { "learnjava.practice" })
public class Config {
	@Value("${DRIVER_CLASS_NAME}")
	private String drivername;

	@Value("${DB_CONNECTION_URL}")
	private String connectionurl;

	@Value("${DB_USER}")
	private String username;

	@Value("${DB_PASSWORD}")
	private String password;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(connectionurl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
 

}
