package com.mock.flight.security;

import com.mock.flight.entities.User;
import com.mock.flight.repository.UserReponsity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserReponsity userReponsity;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReponsity.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Bad credentials");
        }
        return UserDetailImp.build(user);
    }
}
