package com.jwt.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	protected UserDetailsService userDetailsServer(){
		 UserDetails build1 = User.builder().username("avinash")
				 .password(this.password().encode("123")).roles("ADMIN").build();
		 UserDetails build2 = User.builder().username("vicky")
				 .password(this.password().encode("123")).roles("ADMIN").build();
		 return new InMemoryUserDetailsManager(build1,build2);
	}
	
	@Bean
	protected SecurityFilterChain filter(HttpSecurity http) throws Exception
	{
		return http.csrf().disable()
		.authorizeHttpRequests()
		.anyRequest().authenticated()
		.and()
		.httpBasic() 
		.and()
		.build();
		
	}
	
	@Bean
	protected AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setUserDetailsService(this.userDetailsServer());
		dao.setPasswordEncoder(this.password());
		return dao;
	}
	
	@Bean
	protected PasswordEncoder password()
	{
		return new BCryptPasswordEncoder();
	}

}
