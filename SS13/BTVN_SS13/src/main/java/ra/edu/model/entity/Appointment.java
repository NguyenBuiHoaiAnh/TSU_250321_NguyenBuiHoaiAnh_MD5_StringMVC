package ra.edu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    @NotNull(message = "Date is empty!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date is not valid!")
    private LocalDate date;

    @Column(name = "hour", nullable = false)
    @NotNull(message = "Hour is empty!")
    private Time hour;

    @ManyToOne
    @NotNull(message = "Hãy chọn bác sĩ")
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @NotNull(message = "Hãy chọn bệnh nhân")
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
}
