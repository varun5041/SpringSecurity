package com.security.learn.securityProject.Services;

import com.security.learn.securityProject.Models.CustomUserDetails;
import com.security.learn.securityProject.Models.User;
import com.security.learn.securityProject.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private userRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not Found "+ username));
        
        return new CustomUserDetails(user);
    }
}
