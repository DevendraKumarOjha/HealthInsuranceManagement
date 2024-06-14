package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.PatientRequestDto;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.neem.insurancemanagement.service.SubscriberService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private SubscriberService SubscriberService;

    @PostMapping("/create_patient")
    public ResponseEntity<Patient> createPatient(@RequestBody PatientRequestDto requestDto) throws ParseException {
        Patient createPatient = patientService.createPatient(requestDto);

        return ResponseEntity.ok(createPatient);
    }

    @PutMapping("/update_patientDependent")
    public ResponseEntity<Patient> updatePatientDependents(int patientId) {
        Patient patientUpdate = patientService.updatePatientDependents(patientId);
        return ResponseEntity.ok(patientUpdate);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() throws Exception {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @GetMapping("{patientId}")
    public ResponseEntity<Patient> getPatientByPatientId(
            @PathVariable(name = "patientId", required = true) int patientId) throws Exception {
        return ResponseEntity.ok(patientService.findByPatientId(patientId));
    }
}