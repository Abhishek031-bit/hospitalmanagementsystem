package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.models.Bill;
import com.example.hospitalmanagementsystem.repository.AppointmentRepository;
import com.example.hospitalmanagementsystem.repository.BillRepository;
import com.example.hospitalmanagementsystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
    }

    public Bill createBill(Bill bill, Long patientId, Long appointmentId) {
        var patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + appointmentId));

        bill.setPatient(patient);
        bill.setAppointment(appointment);

        return billRepository.save(bill);
    }

    public Bill updateBill(Long id, Bill billDetails) {
        var bill = getBillById(id);
        bill.setAmount(billDetails.getAmount());
        bill.setStatus(billDetails.getStatus());
        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        var bill = getBillById(id);
        billRepository.delete(bill);
    }
}
