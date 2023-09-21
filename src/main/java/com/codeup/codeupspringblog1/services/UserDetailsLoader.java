package com.codeup.codeupspringblog1.services;

import com.codeup.codeupspringblog1.models.User;
import com.codeup.codeupspringblog1.models.UserWIthRoles;
import com.codeup.codeupspringblog1.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailsLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWIthRoles(user);
    }






}
