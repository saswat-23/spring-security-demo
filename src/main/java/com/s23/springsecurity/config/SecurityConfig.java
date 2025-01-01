package com.s23.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
    	httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated())
    				.httpBasic(Customizer.withDefaults())
    				.csrf(req -> req.disable())
    				;
    	return httpSecurity.build();
	}
    
    @Bean
    UserDetailsService userDetailsService() {
    	
    	UserDetails user1 = User.withUsername("user1")
    							.password("{noop}user1")
    							.roles("USER")
    							.build();
    	
    	UserDetails user2 = User.withUsername("app-admin")
    							.password("{noop}admin")
    							.roles("ADMIN")
    							.build();
    	
    	//Using InMemory UserDetails Manager
    	return new InMemoryUserDetailsManager(user1,user2);
    	
    }
	
}
