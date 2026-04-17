package com.example.ecommerce.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.UserEntity;
import com.example.ecommerce.repository.UserRepository;

@Service
public class CustomDetailsUserService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public CustomDetailsUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity usuario = userRepository.findByEmail(email);

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.getRoles().name().replace("ROLE_", ""))
                .build();
    
}
}