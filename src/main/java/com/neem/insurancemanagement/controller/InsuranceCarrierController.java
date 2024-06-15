package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.InsuranceCarrierDto;
import com.neem.insurancemanagement.entity.InsuranceCarrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.neem.insurancemanagement.service.InsuranceCarrierService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InsuranceCarrierController {
    @Autowired
    InsuranceCarrierService insuranceCarrierService;

    @PostMapping("/carrier")
    public ResponseEntity<InsuranceCarrier> createInsurance(@RequestBody InsuranceCarrierDto insuranceCarrierDto) throws ParseException {
        InsuranceCarrier createInsuranceCarrier = insuranceCarrierService.createInsuranceCarrier(insuranceCarrierDto);
        return ResponseEntity.ok(createInsuranceCarrier);
    }

    @GetMapping("/getAllCarriers")
    public ResponseEntity<List<InsuranceCarrier>> getAllInsuranceCarriers() throws Exception {
        return ResponseEntity.ok(insuranceCarrierService.findAllInsuranceCarriers());
    }

    @GetMapping("{carrierId}")
    public ResponseEntity<InsuranceCarrier> getPatientByPatientId(
            @PathVariable(name = "carrierId", required = true) int carrierId) throws Exception {
        return ResponseEntity.ok(insuranceCarrierService.findByInsuranceCarrierId(carrierId));
    }

}
