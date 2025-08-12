package ra.edu.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    @NotEmpty(message = "Full name is empty!")
    private String fullName;
    @NotEmpty(message = "Phone number is empty!")
    private String phoneNumber;
    @NotEmpty(message = "Email is empty!")
    private String email;
    @NotEmpty(message = "Password is empty!")
    private String password;
    @NotEmpty(message = "Address is empty!")
    private String address;
    private String role;
}
