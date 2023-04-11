package com.example.uberassignment.Repository;

import com.example.uberassignment.Model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab , Integer> {
}
