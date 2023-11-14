package com.example.ticket_football.service.impl;


import com.example.ticket_football.entity.RoleEntity;
import com.example.ticket_football.entity.UserEntity;
import com.example.ticket_football.repository.RoleRepository;
import com.example.ticket_football.repository.UserRepository;
import com.example.ticket_football.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username " + username + " was not found in system");
        }

        List<List<RoleEntity>> rolesName = Collections.singletonList(user.getRoles());

        List<GrantedAuthority> grantedList = new ArrayList<>();

        if(!rolesName.isEmpty()) {
            rolesName.forEach((item) -> {
                GrantedAuthority granted = new SimpleGrantedAuthority(item.toString());
                grantedList.add(granted);
            });
        }

        return new User(user.getUsername(), user.getPassword(), grantedList);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
//        return this.userRepository.findByUsername(username);
        return null;
    }
}
