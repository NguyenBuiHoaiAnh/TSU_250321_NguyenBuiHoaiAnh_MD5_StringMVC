package edu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    @NotBlank(message = "Username is empty!")
    private String userName;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is empty!")
    private String password;

    @Column(name = "phone", nullable = false)
    @NotBlank(message = "Phone is empty!")
    @Pattern(regexp = "^0[981672]\\d{7,9}$", message = "Phone is not valid!")
    private String phone;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
