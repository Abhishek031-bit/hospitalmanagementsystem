package com.example.hospitalmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalmanagementsystem.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
