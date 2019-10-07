package learnjava.practice.springdatajpa.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource(value = { "file:C:/properties/application.properties" })
@ComponentScan(basePackages = { "learnjava.practice" })
@EnableJpaRepositories(basePackages = "learnjava.practice.*")
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

	private Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.setProperty("dialect", "org.hibernate.dialecOracle10gDialect");
		prop.setProperty("hbm2ddl.ddl-auto", "update");
		return prop;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "learnjava.practice" });
		JpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendor);
		em.setJpaProperties(hibernateProperties());
		em.setPersistenceUnitName("default");
		em.afterPropertiesSet();
		
		return em;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
