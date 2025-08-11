package ra.edu.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    @NotBlank(message = "Not Null")
    private String username;
    @NotBlank(message = "Not Null")
    @Size(min = 6, message = "Password at least 6 characters")
    private String password;
}
