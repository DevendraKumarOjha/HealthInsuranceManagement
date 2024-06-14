package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.PatientDeductibleRequestDto;
import com.neem.insurancemanagement.dto.PatientDeductibleResponseDto;
import com.neem.insurancemanagement.dto.RemainingStandardDeductibles;
import com.neem.insurancemanagement.entity.PatientDeductible;
import com.neem.insurancemanagement.service.PatientDeductibleService;
import com.neem.insurancemanagement.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/patient/deductible")
public class PatientDeductibleController {

    @Autowired
    private PatientDeductibleService patientDeductibleService;
    @Autowired
    private SubscriberService SubscriberService;

    @PostMapping("/create_patientDeductible")
    public ResponseEntity<PatientDeductible> createPatientDeductible(@RequestBody PatientDeductibleRequestDto requestDto) throws ParseException {
        PatientDeductible createPatient = patientDeductibleService.createPatientDeductible(requestDto);

        return ResponseEntity.ok(createPatient);
    }

    @GetMapping("{patientId}")
    public ResponseEntity<PatientDeductibleResponseDto> getAllPatientDeductiblesByPatient(
            @PathVariable(name = "patientId", required = true) int patientId) throws Exception {
        return ResponseEntity.ok(patientDeductibleService.getAllPatientDeductibleByPatientId(patientId));

    }

    @GetMapping
    public ResponseEntity<List<PatientDeductible>> getAllPatientDeductibles() throws Exception {
        return ResponseEntity.ok(patientDeductibleService.findAllPatientDeductible());
    }
    @PutMapping("/patient_deductibles")
    public ResponseEntity updatePatientDeductible(@RequestBody List<PatientDeductibleRequestDto> requestDto) {
        patientDeductibleService.updatePatientDeductibles(requestDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.OK.value())).build();

    }
    @PutMapping("remaining_standard_amount")
    public ResponseEntity<RemainingStandardDeductibles> updateRemainingDeductibles(int usedDeductibleAmount, String category) {
        RemainingStandardDeductibles remainingAmount = patientDeductibleService.updateRemainingDeductibles(usedDeductibleAmount, category);
        return ResponseEntity.ok(remainingAmount);

    }

}