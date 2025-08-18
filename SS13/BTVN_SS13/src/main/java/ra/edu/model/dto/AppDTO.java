package ra.edu.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppDTO {
    @NotNull(message = "Ngày khám không được để trống")
    private LocalDate date;

    @NotNull(message = "Giờ khám không được để trống")
    private Time hour;

    @NotNull(message = "Phải chọn bệnh nhân")
    private Long doctorId;

    @NotNull(message = "Phải chọn bác sĩ")
    private Long patientId;
}
