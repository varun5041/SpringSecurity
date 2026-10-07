package com.security.learn.securityProject;

import com.security.learn.securityProject.Models.Role;
import com.security.learn.securityProject.Models.User;
import com.security.learn.securityProject.Repository.RoleRepository;
import com.security.learn.securityProject.Repository.userRepository;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.PasswordAuthentication;
import java.util.List;
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

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        Role role1 = roleRepository.findByName("ROLE_ADMIN").orElse(null);
        if(role1==null) {
            role1 = new Role();
            role1.setName("ROLE_ADMIN");
            role1.setRoleid("1");
            roleRepository.save(role1);
        }
        Role role2 = roleRepository.findByName("ROLE_GUEST").orElse(null);
        if(role2==null) {
            role2 = new Role();
            role2.setRoleid("2");
            role2.setName("ROLE_GUEST");
            roleRepository.save(role2);
        }

        User ram = new User();
        ram.setId("101");
        ram.setUsername("RAM");
        ram.setPassword(passwordEncoder.encode("RAM1234"));
        ram.setRoles(List.of(role1,role2));
        userRepository.save(ram);


        User shyam = new User();
        shyam.setId("102");
        shyam.setUsername("SHYAM");
        shyam.setPassword(passwordEncoder.encode("SHYAM1234"));
        shyam.setRoles(List.of(role2));
        userRepository.save(shyam);
    }
}
