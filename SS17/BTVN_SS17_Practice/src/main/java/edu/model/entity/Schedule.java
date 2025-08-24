package edu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departure;
    private LocalDateTime departureTime;

    private String arrival;
    private LocalDateTime arrivalTime;

    private Double price;

    private String image;

    private Integer availableSeat;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}
