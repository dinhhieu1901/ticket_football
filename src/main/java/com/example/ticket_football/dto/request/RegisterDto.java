package com.example.ticket_football.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterDto {
    @NotBlank(message = "Tên đăng nhập không được để trống!")
    private String username;

    @NotBlank(message = "Bạn chưa nhập địa chỉ email!")
    @Email(message = "Email chưa đúng định dạng!")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống!")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Mật khẩu phải có tối thiểu 8 kí tự, ít nhất 1 kí tự số và 1 kí tự chữ!")
    private String password;

    @NotBlank(message = "Bạn chưa nhập số điện thoại!")
    @Pattern(regexp = "^[0-9]*$", message = "Số điện thoại không đúng định dạng!")
    private String phone;
}
