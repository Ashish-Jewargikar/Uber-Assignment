package com.example.uberassignment.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="driver")
@NoArgsConstructor
@AllArgsConstructor

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String mobile;
    private String password;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Cab cab;

    @OneToMany(mappedBy = "driver",cascade=CascadeType.ALL)
    private List<TripBooking> tripBookingList = new ArrayList<>();


}
