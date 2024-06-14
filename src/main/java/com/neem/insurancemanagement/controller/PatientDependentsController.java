package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.PatientDependentDto;
import com.neem.insurancemanagement.entity.PatientDependents;
import com.neem.insurancemanagement.service.PatientDependentService;
import com.neem.insurancemanagement.service.PatientService;
import com.neem.insurancemanagement.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/patient/dependent")
public class PatientDependentsController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private SubscriberService SubscriberService;
    @Autowired
    private PatientDependentService patientDependentService;

    @PostMapping("/add_dependent")
    public ResponseEntity<PatientDependents> createPatientDependent(@RequestBody PatientDependentDto requestDto) throws ParseException {
        PatientDependents createPatientDependent = patientDependentService.createPatientDependent(requestDto);

        return ResponseEntity.ok(createPatientDependent);
    }

    @GetMapping
    public ResponseEntity<List<PatientDependents>> getAllPatientDependents() throws Exception {
        return ResponseEntity.ok(patientDependentService.findAllPatientDependents());
    }

    @GetMapping("{patientId}")
    public ResponseEntity<PatientDependents> getPatientByPatientId(
            @PathVariable(name = "patientId", required = true) int patientId) throws Exception {
        return ResponseEntity.ok(patientDependentService.findPatientDependentByPatientId(patientId));
    }
}