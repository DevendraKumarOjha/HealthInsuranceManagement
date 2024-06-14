package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.DeductibleRequestDto;
import com.neem.insurancemanagement.entity.Deductible;
import com.neem.insurancemanagement.entity.PatientDeductible;
import com.neem.insurancemanagement.service.DeductibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/deductibles")
public class DeductibleController {

    @Autowired
    DeductibleService deductibleService;

    @PostMapping("/create_deductible")
    public ResponseEntity<Deductible> createDeductible(@RequestBody DeductibleRequestDto deductibleDto) throws ParseException {
        Deductible createPatient = deductibleService.createDeductible(deductibleDto);

        return ResponseEntity.ok(createPatient);
    }


    @GetMapping("/allDeductibles")
    public List<Deductible> getAllDeductibles() {
        return deductibleService.getAllDeductibles();
    }


    @GetMapping("/{deductibleId}")
    public ResponseEntity<Deductible> getDeductibleById(@PathVariable(value = "deductibleId") int deductibleId) {
        Deductible deductible = deductibleService.getDeductibleById(deductibleId);
        if (deductible == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(deductible);
    }

    @PutMapping("/{id}")
    public List<PatientDeductible> updateDeductible(@RequestBody List<PatientDeductible> deductibleDetails) {
        List<PatientDeductible> deductible = deductibleService.updateDeductible(deductibleDetails);
        return deductible;
    }
//update deductibel here amount,category to send in request;
}
