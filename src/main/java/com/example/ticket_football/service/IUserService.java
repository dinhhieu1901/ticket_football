package com.example.ticket_football.service;

import com.example.ticket_football.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserEntity getUserByUsername(String usernam);
}
