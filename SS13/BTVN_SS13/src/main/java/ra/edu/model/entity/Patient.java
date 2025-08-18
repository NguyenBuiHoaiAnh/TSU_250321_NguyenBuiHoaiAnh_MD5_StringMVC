package ra.edu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name",length = 70,nullable = false)
    @NotBlank(message = "Full name is empty!")
    private String fullName;

    @Column(name = "dob",nullable = false)
    @NotNull(message = "Dob is empty!")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Past(message = "Dob is not valid!")
    private LocalDateTime dob;

    @Column(name = "contact", nullable = false)
    @NotBlank(message = "Contact is empty!")
    private String contact;

    @Column(name = "phone", length = 20, nullable = false, unique = true)
    @NotBlank(message = "Phone is empty!")
    @Pattern(regexp = "^0[981672]\\d{7,9}$", message = "Phone is not valid!")
    private String phone;

    @Column(name = "status")
    private Boolean status = true;
}
