package com.example.hospitalmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalmanagementsystem.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
