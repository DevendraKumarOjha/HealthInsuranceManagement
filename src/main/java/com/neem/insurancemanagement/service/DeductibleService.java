package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.DeductibleRequestDto;
import com.neem.insurancemanagement.entity.Deductible;
import com.neem.insurancemanagement.entity.PatientDeductible;
import com.neem.insurancemanagement.repository.DeductibleRepository;
import com.neem.insurancemanagement.repository.PatientDeductibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class DeductibleService {

    @Autowired
    DeductibleRepository deductibleRepository;
    @Autowired
    PatientDeductibleRepository patientDeductibleRepository;

    public Deductible createDeductible(DeductibleRequestDto deductibleDto) throws ParseException {

        Deductible deductible = new Deductible();
        deductible.setCategory(deductibleDto.getCategory());
        deductible.setIndividualAmount(deductibleDto.getIndividualAmount());
        deductible.setNonStandard(deductibleDto.isNonStandard());
        return deductibleRepository.save(deductible);
    }

    public List<Deductible> getAllDeductibles() {
        return deductibleRepository.findAll();
    }

    public Deductible getDeductibleById(int deductibleId) {
        Deductible deductible = deductibleRepository.findById(deductibleId).orElse(null);
        return deductible;
    }

    public List<PatientDeductible> updateDeductible(List<PatientDeductible> deductibleDetails) {

        /*PatientDeductible deductible = patientDeductibleRepository.findById(deductibleId).orElse(null);
        if (deductible == null) {
            return null;
        }
        if (!deductibleDetails.getCategory().isEmpty())
            deductible.setCategory(deductibleDetails.getCategory());
        if (deductibleDetails.getIndividualAmount() != 0)
            deductible.setIndividualAmount(deductibleDetails.getIndividualAmount());
        if (deductibleDetails.isNonStandard())
            deductible.setNonStandard(deductibleDetails.isNonStandard());*/

        List<PatientDeductible> listOfUpdatedDeductibles = patientDeductibleRepository.saveAll(deductibleDetails);
        return listOfUpdatedDeductibles;
    }

}
