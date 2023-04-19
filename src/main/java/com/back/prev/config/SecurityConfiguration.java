package com.back.prev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private AuthenticationEntryPoint authEntryPoint;
	
//	@Value("${auth.api.user}")
//	private String user;
//	
//	@Value("${auth.api.passwd}")
//	private String passwd;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("test").password("{noop}test").roles("ADMIN").and();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http.csrf().disable().authorizeRequests()
        	.antMatchers("/api/**").hasAuthority("ADMIN")
            .anyRequest().authenticated().and().requestCache()
            .requestCache(new NullRequestCache()).and().
            sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .httpBasic().authenticationEntryPoint(authEntryPoint);
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

  
}