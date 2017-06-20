package almeida.fernando.bootheroku.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BootHerokuSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().maximumSessions(1);
		http.authorizeRequests()
		
		.antMatchers("/exercicios/**").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic();
		
	}
}
