package com.springboot.learning.springbootlearning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	 public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/resources/**", "/index.html", "/login.html",
	   "/partials/**", "/", "/error/**", "/questions**", "/employees/**");
	 }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .authorizeRequests()
         .anyRequest().authenticated()
         .and()
         .httpBasic();
		
//		http
//        .authorizeRequests()
//           .antMatchers("/questions","/employees").permitAll()
//           .anyRequest().authenticated()
//           .and()
//           .httpBasic();
		
//		http
//			.authorizeRequests()
//			.antMatchers("/questions**").permitAll().and()
//			.authorizeRequests().anyRequest().authenticated().and();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}password")
            .roles("USER");
    }

}
