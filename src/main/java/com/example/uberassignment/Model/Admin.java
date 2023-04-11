package com.example.uberassignment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int adminId;
  private String username;
  private String password;

}
