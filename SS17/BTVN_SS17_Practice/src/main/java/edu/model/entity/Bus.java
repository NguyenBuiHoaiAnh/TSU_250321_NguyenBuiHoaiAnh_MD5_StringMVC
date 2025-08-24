package edu.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", nullable = false, unique = true)
    @NotBlank(message = "License Plate is empty!")
    private String licensePlate;

    @Column(name = "capacity", nullable = false)
    @NotNull(message = "Capacity is empty!")
    private Integer capacity;

    @Column(name = "type_seat", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeSeat typeSeat;

}
