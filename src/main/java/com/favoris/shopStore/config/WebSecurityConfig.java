package com.favoris.shopStore.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan("com.*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Autowired
       private DataSource dataSource;

       @Override
       protected void configure(HttpSecurity http) throws Exception {

           http.authorizeRequests()
                    .antMatchers("/login", "/registration").permitAll()
                    .antMatchers("/*").hasRole("USER")
                    .and()
                        .formLogin()
                        .loginPage("/login")
                        .failureForwardUrl("/registration")
                        .successForwardUrl("/")
                        .passwordParameter("password")
                        .usernameParameter("username")
                        .permitAll()
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .and()
                        .csrf().disable();
        }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u ");//inner join user_role ur on u.id=ur.user_id where u.username=?
    }



}























