package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.models.Appointment;
import com.example.hospitalmanagementsystem.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable(value = "id") Long id) {
        var appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok().body(appointment);
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment,
                                                       @RequestParam Long patientId,
                                                       @RequestParam Long doctorId) {
        var createdAppointment = appointmentService.createAppointment(appointment, patientId, doctorId);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable(value = "id") Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
