package learnjava.practice.springjdbc.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import learnjava.practice.springjdbc.model.EodData;

//this indicates this class contains one or more bean definitions
@Configuration
//cam load files from file system or classpath
@PropertySource(value = { "file:C:/properties/application.properties" })
//componentscan  will scan for all the package mentioned for creating spring beans annotated with
//@component,@service,@repository...... 
@ComponentScan(basePackages = { "learnjava.practice.springjdbc" })
public class Configurations {

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

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

}
