package com.clinicDental.persistence.entity.dto;

import lombok.Data;

@Data
public class SigninDto {
    private String name;
    private String username;
    private String email;
    private String password;

    public SigninDto() {
    }
}
