package edu.model.dto;

import edu.model.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegister {
    @NotBlank(message = "Username chưa nhập!")
    private String username;
    @NotBlank(message = "Password chưa nhập!")
    private String password;
    @NotBlank(message = "Email chưa nhập!")
    private String email;
    @NotBlank(message = "Phone chưa nhập!")
    private String phone;
    @NotNull(message = "Role chưa nhập!")
    private Role role;
    private String confirmPassword;
}
