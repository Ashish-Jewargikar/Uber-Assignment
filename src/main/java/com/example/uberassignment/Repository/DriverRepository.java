package com.example.uberassignment.Repository;

import com.example.uberassignment.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
