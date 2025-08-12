package ra.edu.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Booking {
    private int id;
    private int customerId;
    private int roomId;
    private LocalDate bookingDate;
    private Double price;
}
