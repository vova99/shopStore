package com.favoris.shopStore.config;


import com.favoris.shopStore.service.UserService;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Autowired
       DataSource dataSource;

       @Autowired
       UserService userService;


       @Override
       protected void configure(HttpSecurity http) throws Exception {

           http.authorizeRequests()
//                    .antMatchers("/login", "/registration").permitAll()
                    .antMatchers("/*").permitAll()
//                    .antMatchers("/*").authenticated()
                    .and()
                        .formLogin()
                        .loginPage("/login")
                        .failureForwardUrl("/login?error=true")
                        .successForwardUrl("/index")
                        .passwordParameter("password")
                        .usernameParameter("username")
                        .permitAll()
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .and()
                        .csrf().disable();
        }



    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active from usr where username=?")
                .authoritiesByUsernameQuery("select u.username, u.roles from usr u where u.username=?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());//inner join user_role ur on u.id=ur.user_id where u.username=?
    }



}























