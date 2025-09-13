package com.example.hospitalmanagementsystem.repository;

import com.example.hospitalmanagementsystem.models.Appointment;
import com.example.hospitalmanagementsystem.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByAppointment(Appointment appointment);
}