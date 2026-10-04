package com.security.learn.securityProject;

import com.security.learn.securityProject.Models.User;
import com.security.learn.securityProject.Repository.userRepository;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.PasswordAuthentication;
import java.util.UUID;

@SpringBootApplication
public class SecurityProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);
	}

    @Autowired
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        User user = userRepository.findByUsername("varun5041").orElse(null);
        if(user==null) {
            user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername("varun5041");
            user.setPassword(passwordEncoder.encode("VArun5041@"));
            user.setRole("USER");
            userRepository.save(user);
            System.out.println("USER CREATED!");
        }else {
            System.out.println("User already exists!");
        }

//        System.out.println(passwordEncoder.encode("Varun5041@"));
//        System.out.println(passwordEncoder.encode("Varun5041@"));
//        System.out.println(passwordEncoder.matches(
//                "Varun5041@",
//                "$2a$10$.Ve5yNWMIMfjBSsJs85XNO1wzPHwwld1m6u0RGJcfAMoSm5dMSPRO"
//        ));


    }
}
