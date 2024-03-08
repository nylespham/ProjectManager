package com.jrp.projectmanager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    DataSource dataSource;
    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource){
        JdbcUserDetailsManager userFinal = new JdbcUserDetailsManager(dataSource);
        userFinal.setUsersByUsernameQuery("SELECT username,password,enabled FROM user_accounts WHERE username = ?");
        userFinal.setAuthoritiesByUsernameQuery("SELECT username,role FROM user_accounts WHERE username=?");
        return userFinal;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/projects/new").hasRole("ADMIN")
//			.antMatchers("/projects/save").hasRole("ADMIN")
//			.antMatchers("/employees/new").hasRole("ADMIN")
//			.antMatchers("/employees/save").hasRole("ADMIN")
                                .requestMatchers("/", "/**").permitAll()
                        )
                .formLogin(form -> form.permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

