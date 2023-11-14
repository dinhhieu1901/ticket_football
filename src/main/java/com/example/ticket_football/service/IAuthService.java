package com.example.ticket_football.service;

import com.example.ticket_football.dto.request.LoginDto;
import com.example.ticket_football.dto.request.RegisterDto;

import java.util.Map;
import java.util.Objects;

public interface IAuthService {
    Map<String, Objects> login(LoginDto userLogin);

    Map<String, Objects> register(RegisterDto userRegister);
}
