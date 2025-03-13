package com.Project._5.SpringSecurityLearning.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())    // disableing the csrf token
                .authorizeHttpRequests(     // this will tell it to authenticate all the requests before passing
                        request-> request
                                .requestMatchers( "register","login").permitAll()  //jaha jaha register ya login use ho raha hoga usko authentication ki zaroorat nahi
                                .anyRequest().authenticated()
                )
                //.formLogin(Customizer.withDefaults())    // will give me a basic form
                .httpBasic(Customizer.withDefaults());   // adding basic authentication with a popup form if form login is not mentioned
        return httpSecurity.build();
    }
}
