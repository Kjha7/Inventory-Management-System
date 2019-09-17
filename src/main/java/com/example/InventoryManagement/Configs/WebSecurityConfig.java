package com.example.InventoryManagement.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	@Autowired
	private UserDetailsServiceImpl jwtUserDetailsService;
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//	    return super.userDetailsService();
//	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	// configure AuthenticationManager so that it knows from where to load
	// user for matching credentials
	// Use BCryptPasswordEncoder
		System.out.println("WebSecurityConfig: configureGlobal");
	auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	      authenticationProvider.setUserDetailsService(jwtUserDetailsService);
	      authenticationProvider.setPasswordEncoder(passwordEncoder());
	      return authenticationProvider;
	 }
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	// We don't need CSRF for this example
	httpSecurity.csrf().disable()
	// dont authenticate this particular request
	.authorizeRequests().antMatchers( "/user/**").permitAll().
	// all other requests need to be authenticated
	anyRequest().authenticated().and().
	// make sure we use stateless session; session won't be used to
	// store user's state.
	exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	// Add a filter to validate the tokens with every request
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	

}
