package learnjava.practice;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("vponnam").password("vponnam").roles("dev") .and()
		 * .withUser("vponnam123").password("vponnam123").roles("dev") .and()
		 * .withUser("vponnamadmin").password("admin").roles("admin");
		 */
		/*
		 * .withDefaultSchema()
		 * .withUser(User.withUsername("vishnu").password("vishnu").roles("admin"))
		 * .withUser(User.withUsername("ponnam").password("ponnam").roles("admin"));
		 * 
		 */
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,enabled from users where username=?")
				.authoritiesByUsernameQuery("select username,authority from authorities where username=?");

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// -----> /** means all the url
		// hasAnyRole vs hasAnyAuthority
		// hasAuthority('ROLE_ADMIN') means the the same as hasRole('ADMIN') because the
		// ROLE_ prefix gets added automatically
		http.authorizeRequests().antMatchers("/admin")
			.hasAuthority("ROLE_admin")
			.and()
			.formLogin();

	}

}
