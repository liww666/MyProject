package com.sunyard.myproject.config;

import com.sunyard.myproject.security.LoginSuccessHandler;
import com.sunyard.myproject.security.MySecurityFilter;
import com.sunyard.myproject.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

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

    @Autowired
    private MySecurityFilter mySecurityFilter;

    @Bean
    public  UserDetailsService myUserDetailsService() {
        return new MyUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)
                .authorizeRequests()
                .anyRequest().authenticated()
//                .antMatchers("/topic").access("hasRole('ADMIN')")
//                .anyRequest().hasRole("USER")
//                .antMatchers("/**").access("hasRole('USER')")
//                .antMatchers("/**").permitAll()
                .and()
                .formLogin()
//                .loginPage("/login")
//                .permitAll()
                .successHandler(loginSuccessHandler())
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*
        忽视的请求会被所有的springSecurity所有的过滤器忽略，
        意味着在该请求中不能通过SecurityContextHolder获取用户信息
         */
        web.ignoring().antMatchers("/hello");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/**
 * inMemoryAuthentication
 */
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().
//                withUser("admin").password("admin").roles("ADMIN","USER");

        /*
        jdbcAuthentication
         */
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("" +
//                " select username,password,true " +
//                " from tb_user where username=?")
//        .authoritiesByUsernameQuery(" select username,'ROLE_USER' " +
//                " from tb_user where username=? ");
//        .passwordEncoder(new StandardPasswordEncoder("53cr3t"));

        /*
        自定义UserDetailsService
         */
        auth.userDetailsService(myUserDetailsService());
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler();
    }

}

