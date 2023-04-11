package com.example.uberassignment.Model;

import com.example.uberassignment.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="trip_booking")
@NoArgsConstructor
@AllArgsConstructor
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripBookingId;
    private String fromBooking;
    private String toLocation;
    private int distance;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;
    private int bill;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;
}
