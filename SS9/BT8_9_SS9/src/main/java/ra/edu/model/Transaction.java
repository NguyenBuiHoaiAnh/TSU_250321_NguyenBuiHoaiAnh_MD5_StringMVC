package ra.edu.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int id;

    @NotBlank(message = "Mô tả không được để trống")
    private String description;

    @NotNull(message = "Giá trị giao dịch không được để trống")
    @DecimalMin(value = "0.01", message = "Giá trị giao dịch không âm")
    private Double amount;

    private boolean type;
}
