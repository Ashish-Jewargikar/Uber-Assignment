package com.example.uberassignment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cab")
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;
    private int ratePerKm;
    private boolean available;

    @OneToOne
    @JoinColumn(name="driver_id")
    private Driver driver;


}
