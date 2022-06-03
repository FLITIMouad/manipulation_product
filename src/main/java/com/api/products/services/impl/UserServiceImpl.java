package com.api.products.services.impl;

import com.api.products.Entity.User;
import com.api.products.Models.DetailsOfUser;
import com.api.products.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService  {
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
         
            User user = userRepository.findByUsername(username);
             
            if (user == null) {
                throw new UsernameNotFoundException("Could not find user");
            }
             
            return new DetailsOfUser(user);
        
    }
}
