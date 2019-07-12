package com.github.xenteros.security;

import com.github.xenteros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
class WebConfig extends WebSecurityConfigurerAdapter {

    private UserRepository userRepository;

    @Autowired
    public WebConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api**").authenticated()
                .antMatchers("/api/users/*/enable").permitAll()
                .antMatchers("/login-page.html").permitAll()
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .successForwardUrl("/login-success")
                .loginPage("/login")
                .permitAll();

        http.logout()
                .logoutUrl("/logout")
                .permitAll()
                .logoutSuccessUrl("/login");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(userRepository);
    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("USER").password("pass").roles("USER")
//                .and()
//                .withUser("ADMIN").password("password").roles("ADMIN");
//
//    }
}
