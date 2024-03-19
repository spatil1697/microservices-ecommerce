package com.ecommerce.discoveryserver.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Value("${eureka.username}")
    private String username;

    @Value("${eureka.password}")
    private String password;
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder){
        try {
            authenticationManagerBuilder.inMemoryAuthentication()
                    .passwordEncoder(NoOpPasswordEncoder.getInstance())
                    .withUser(username).password(password)
                    .authorities("USER");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests().anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

}
