package ra.edu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull(message = "Không để trống id")
    private long id;
    @NotBlank(message = "Không để trống tên")
    private String name;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Không để trống email")
    private String email;
    @NotBlank(message = "Password không được để trống")
    @Size(max = 20, message = "Không quá 20 kí tự")
    private String password;
}
