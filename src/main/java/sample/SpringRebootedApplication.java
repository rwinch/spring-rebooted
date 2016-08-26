package sample;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class SpringRebootedApplication {

	@Bean
	JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager();
		jdbc.setDataSource(dataSource);
		jdbc.setUsersByUsernameQuery("select username, password, true from user where username = ?");
		jdbc.setAuthoritiesByUsernameQuery("select username, 'ROLE_USER' from user where username = ?");
		
		return jdbc;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRebootedApplication.class, args);
	}
}
