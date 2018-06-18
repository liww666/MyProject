package com.sunyard.myproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2018/4/1.
 */
@Profile("prod")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/*").access("hasRole('USER')")
//                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
//                .loginPage("/login")
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/**
 * inMemoryAuthentication
 */
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().
                withUser("admin").password("admin").roles("ADMIN","USER");
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("" +
//                " select username,password,true " +
//                " from tb_user where username=?")
//        .authoritiesByUsernameQuery(" select username,'ROLE_USER' " +
//                " from tb_user where username=? ")
//        .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
    }
}

