package com.clinicDental.persistence.entity.dto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginDto {
    private String usernameOrEmail;
    private String password;

    public LoginDto() {
    }

}
