package ra.edu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 70, nullable = false)
    @NotBlank(message = "Full name is empty!")
    private String fullName;

    @Column(name = "specialization", nullable = false)
    @NotBlank(message = "Specialization is empty!")
    private String specialization;

    @Column(name = "contact", nullable = false)
    @NotBlank(message = "Contact is empty!")
    private String contact;

    @Column(name = "phone", length = 20, nullable = false, unique = true)
    @NotBlank(message = "Phone is empty!")
    @Pattern(regexp = "^0[981672]\\d{7,9}$", message = "Phone is not valid!")
    private String phone;

    @Column(name = "status", columnDefinition = "boolean default true")
    private Boolean status = true;


//    public Doctor() {
//    }
//
//    public Doctor(Long id, String fullName, String specialization, String contact, String phone, Boolean status) {
//        this.id = id;
//        this.fullName = fullName;
//        this.specialization = specialization;
//        this.contact = contact;
//        this.phone = phone;
//        this.status = status;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getSpecialization() {
//        return specialization;
//    }
//
//    public void setSpecialization(String specialization) {
//        this.specialization = specialization;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public void setContact(String contact) {
//        this.contact = contact;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
}
