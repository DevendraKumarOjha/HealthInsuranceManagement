package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.InsuranceRequestDto;
import com.neem.insurancemanagement.entity.Insurance;
import com.neem.insurancemanagement.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    @Autowired
    InsuranceService InsuranceService;

    @PostMapping("/create_insurance")
    public ResponseEntity<Insurance> createInsurance(@RequestBody InsuranceRequestDto insuranceRequestDto) throws ParseException {
        Insurance createInsurance = InsuranceService.createInsurance(insuranceRequestDto);
        return ResponseEntity.ok(createInsurance);
    }

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() throws Exception {
        return ResponseEntity.ok(InsuranceService.findAllInsurances());
    }

    @GetMapping("{insurance_Id}")
    public ResponseEntity<Insurance> getInsuranceCarrierById(
            @PathVariable(name = "insurance_Id", required = true) int insurance_Id) throws Exception {
        return ResponseEntity.ok(InsuranceService.findByInsuranceId(insurance_Id));
    }
}
