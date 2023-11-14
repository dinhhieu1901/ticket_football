package com.example.ticket_football.service.impl;

import com.example.ticket_football.common.Constants;
import com.example.ticket_football.common.MessageResponse;
import com.example.ticket_football.dto.request.LoginDto;
import com.example.ticket_football.dto.request.RegisterDto;
import com.example.ticket_football.exceptions.ResponseException;
import com.example.ticket_football.repository.UserRepository;
import com.example.ticket_football.security.JWTGenerator;
import com.example.ticket_football.service.IAuthService;
import com.example.ticket_football.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final JWTGenerator jwtGenerator;
    private final IUserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Map<String, Objects> login (LoginDto userLogin) {
        boolean checkExisted = userRepository.existsByUsername(userLogin.getUsername());

        if(!checkExisted) {
            throw new ResponseException(MessageResponse.USER_NOT_EXISTED,
                    HttpStatus.UNAUTHORIZED,
                    Constants.Code.USER_NOT_EXISTED.getCode());
        }

        UserDetails userDetails = this.userService.loadUserByUsername(userLogin.getUsername());

        boolean checkMatch = this.comparePassword(userDetails.getPassword(), userLogin.getPassword());

        if(!checkMatch) {
            throw new ResponseException(MessageResponse.PASSWORD_NOT_MATCHES,
                    HttpStatus.BAD_REQUEST,
                    Constants.Code.PASSWORD_NOT_MATCHES.getCode());
        }

        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getAuthorities()));

//        String jwt = this.jwtGenerator.generateToken();
        return null;
    }

    @Override
    public Map<String, Objects> register(RegisterDto userRegister) {
        return null;
    }

    public boolean comparePassword(String cPassword, String pPassword) {
        return passwordEncoder.matches(pPassword, cPassword);
    }
}
