package com.ganbarli.insurance.security;


import com.ganbarli.insurance.models.user.User;
import com.ganbarli.insurance.security.CustomerDetails;
import com.ganbarli.insurance.services.userService.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userService.getUserByEmail(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("Email not found!");
        }
        System.out.println("loadUserByUsername : " + user.get().toString());
        return user.map(CustomerDetails::new).get();

    }
}