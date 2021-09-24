package com.dexbot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter {
	
	private static final String REMEMBERME_KEY = "Mg3tKw1zN.+KVkOE@ZAMyPD4R|tKR#";
	
//	@Autowired
//	private UserDetailService userDetailService;
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder(12);
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(this.userDetailService).passwordEncoder(passwordEncoder());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/static/**", "/**", "/*").permitAll()
				.and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/")
				.failureUrl("/login-error").usernameParameter("username").passwordParameter("password")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
				.deleteCookies("JSESSIONID")
				.and().rememberMe().key(REMEMBERME_KEY)
				.and().exceptionHandling().accessDeniedPage("/403");
		
		http.sessionManagement().invalidSessionUrl("/login?expired=true");
	}
}
