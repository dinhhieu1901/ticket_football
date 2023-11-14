package com.example.ticket_football.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class LoginDto {
    @NotBlank(message = "Tên đăng nhập không được để trống!")
    private String username;
    @NotBlank(message = "Mật khẩu không được để trống!")
    private String password;

    /*
     * role:
     *  ROLE_ADMIN
     *  ROLE_USER
     */
    @NotBlank(message = "Role is required!")
    private String role;
}
