package com.example.uberassignment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String mobile;
    private String password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<TripBooking> tripBookingList = new ArrayList<>();
}
