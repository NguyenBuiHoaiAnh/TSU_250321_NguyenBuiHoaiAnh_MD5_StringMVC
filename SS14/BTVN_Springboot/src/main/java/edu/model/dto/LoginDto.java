package edu.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank(message = "Username is empty!")
    private String username;

    @NotBlank(message = "Password is empty!")
    private String password;
}
