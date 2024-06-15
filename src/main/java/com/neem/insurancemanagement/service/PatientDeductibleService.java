package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.PatientDeductibleRequestDto;
import com.neem.insurancemanagement.dto.PatientDeductibleResponseDto;
import com.neem.insurancemanagement.dto.RemainingStandardDeductibles;
import com.neem.insurancemanagement.entity.Deductible;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.entity.PatientDeductible;
import com.neem.insurancemanagement.entity.PatientDependents;
import com.neem.insurancemanagement.exception.PatientDeductibleNotFoundException;
import com.neem.insurancemanagement.repository.DeductibleRepository;
import com.neem.insurancemanagement.repository.PatientDeductibleRepository;
import com.neem.insurancemanagement.repository.PatientDependentsRepository;
import com.neem.insurancemanagement.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PatientDeductibleService {

    @Autowired
    PatientDeductibleRepository patientDeductibleRepository;
    @Autowired
    DeductibleRepository deductibleRepository;
    @Autowired
    PatientDependentsRepository patientDependentsRepository;
    @Autowired
    PatientRepository patientRepository;

    public PatientDeductible createPatientDeductible(PatientDeductibleRequestDto requestDto) {

        Deductible deductible = deductibleRepository.findByCategory(requestDto.getCategory());

        PatientDeductible patientDeductible = new PatientDeductible();
        patientDeductible.setDeductibleId(deductible.getDeductibleId());
        patientDeductible.setPatientId(requestDto.getPatientId());

        if ("Standard".equals(requestDto.getCategory())) {
            patientDeductible.setStandardDeductibleAmount(requestDto.getStandardDeductibleAmount());
            patientDeductible.setStandardDeductibleRemainingAmount(requestDto.getStandardDeductibleUsedAmount());
        }
        patientDeductible.setCategory(requestDto.getCategory());
        patientDeductible.setIndividualAmount(requestDto.getIndividualAmount());
        patientDeductible.setNonStandard(requestDto.isNonStandard());

        patientDeductibleRepository.save(patientDeductible);

        if (patientDeductible.getDeductibleId() > -1) {
            return patientDeductible;
        } else {
            log.error("A problem occurred during creating patient deductible");
            throw new PatientDeductibleNotFoundException("A problem occurred during creating patient deductible");
        }
    }

    public List<PatientDeductible> findAllPatientDeductible() throws Exception {
        List<PatientDeductible> patientDeductibles = patientDeductibleRepository.findAll();
        try {

            if (patientDeductibles.size() < 1) {
                log.error("There is no patients deductible available ");
                throw new PatientDeductibleNotFoundException("There is no patient deductible available ");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return patientDeductibles;
    }

    public List<PatientDeductible> getDeductibleByPatientId(int patientId) {
        return patientDeductibleRepository.getDeductibleByPatientId(patientId);
    }


    public PatientDeductibleResponseDto getAllPatientDeductibleByPatientId(int patientId) {
        List<PatientDeductible> patientDeductibles = patientDeductibleRepository.getDeductibleByPatientId(patientId);

        Patient patient = patientRepository.findById(patientId);

        List<Deductible> deductiblesList = new ArrayList<>();

        List<PatientDependents> dependents = patientDependentsRepository.getAllDependents(patientId);
        PatientDeductibleResponseDto dto = new PatientDeductibleResponseDto();

        dto.setPatient(patient);
        dto.setPatientDependents(dependents);

        for (PatientDeductible patientDeductible : patientDeductibles) {

            deductiblesList.add(deductibleRepository.findById(patientDeductible.getDeductibleId()).get());

        }

        dto.setDeductibles(deductiblesList);

        return dto;
    }

    public void updatePatientDeductibles(List<PatientDeductibleRequestDto> requestDto) {

        for (PatientDeductibleRequestDto dto : requestDto) {
            if (dto.isNonStandard()) {
                PatientDeductible patientDeductible = patientDeductibleRepository.findByDeductibleIdAndPatientId(dto.getPatientId(), dto.getDeductibleId());
                patientDeductible.setIndividualAmount(dto.getIndividualAmount());
                patientDeductibleRepository.save(patientDeductible);

            }
        }
    }

    public RemainingStandardDeductibles updateRemainingDeductibles(int usedDeductibleAmount, String category) {
        RemainingStandardDeductibles remainingStandardDeductibles = new RemainingStandardDeductibles();
        if ("Standard".equals(category)) {
            PatientDeductible patientDeductible = patientDeductibleRepository.findDeductiblesByCategory(category);
            int standardAmount = patientDeductible.getStandardDeductibleRemainingAmount();
            int remainingAmount = patientDeductible.getStandardDeductibleRemainingAmount() - usedDeductibleAmount;

            patientDeductible.setStandardDeductibleRemainingAmount(remainingAmount);

            patientDeductibleRepository.save(patientDeductible);

            remainingStandardDeductibles.setRemainingAmount(remainingAmount);
            remainingStandardDeductibles.setUsedAmount(usedDeductibleAmount);
            remainingStandardDeductibles.setStandardAmount(standardAmount);
        }
        return remainingStandardDeductibles;
    }
}
