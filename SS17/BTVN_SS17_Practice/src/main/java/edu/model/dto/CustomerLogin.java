package edu.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLogin {

    @NotBlank(message = "Username is empty!")
    private String username;

    @NotBlank(message = "Password is empty!")
    private String password;
}