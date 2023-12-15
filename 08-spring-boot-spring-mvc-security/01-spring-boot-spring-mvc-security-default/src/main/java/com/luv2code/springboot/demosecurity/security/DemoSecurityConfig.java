package com.luv2code.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*add support for JDBC (no more hardcoded users)*/

    /*use custom tables for security*/
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        /*define query to retrieve a user by username*/
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");

        /*define query to retrieve the authorities/roles by username*/
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests( configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
        )
                .formLogin( form->
                form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser") /*no need request mapping controller (you can put whatever name you want)*/
                        .permitAll()
        )
                .logout(logout-> logout.permitAll()
        )
                .exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied")
        ) ;

        return httpSecurity.build();
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails john = User.builder().
                username("john").password("{noop}test1234").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().
                username("mary").password("{noop}test1234").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan = User.builder().
                username("susan").password("{noop}test1234").roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(john,mary, susan);
    }*/
}
