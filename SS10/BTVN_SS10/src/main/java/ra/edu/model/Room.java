package ra.edu.model;

import lombok.*;
import ra.edu.model.dto.RoomStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private int id;
    private String roomName;
    private String roomType;
    private RoomStatus status;
    private boolean isDelete;
    private double price;
    private String image;
}
