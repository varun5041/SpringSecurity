package com.security.learn.securityProject.Controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}


//@Bean
//    public UserDetailsService userDetailsService(){
//
//        //creating user
//        UserDetails user1 = User.withDefaultPasswordEncoder()
//                .username("varun5041")
//                .password("Varun5041@")
//                .roles("ADMIN","GUEST")
//                .build();
//
//        UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("SAHIL")
//                .password("SAHIL123")
//                .roles("GUEST")
//                .build();
//
//        //creating user detail manager in memory
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2);
//
//        return inMemoryUserDetailsManager;
//    }
