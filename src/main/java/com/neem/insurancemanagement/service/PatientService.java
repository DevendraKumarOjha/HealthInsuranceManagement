package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.PatientRequestDto;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.entity.PatientDependents;
import com.neem.insurancemanagement.entity.Subscriber;
import com.neem.insurancemanagement.exception.PatientNotFoundException;
import com.neem.insurancemanagement.repository.PatientDependentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neem.insurancemanagement.repository.PatientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    PatientDependentsRepository patientDependentsRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Patient createPatient(PatientRequestDto requestDto) throws ParseException {
        Patient patient = new Patient();
        patient.setFirstName(requestDto.getFirstName());
        patient.setLastName(requestDto.getLastName());
        patient.setDateOfBirth(sdf.parse(String.valueOf(requestDto.getDateOfBirth())));
        patient.setGender(requestDto.getGender());
        patient.setAge(requestDto.getAge());
        patient.setInsuranceType("Primary");
        patient.setInsurances(requestDto.getInsurance());
        //patient.setPatientDeductible(requestDto.getPatientDeductible());

        patientRepository.save(patient);

        if (patient.getId() > -1) {
            return patient;
        } else {
            log.error("A problem occurred during creating patient");
            throw new PatientNotFoundException("A problem occurred during creating patient");
        }

    }

    public List<Patient> findAllPatients() throws Exception {
        List<Patient> patients = patientRepository.findAll();
        try {

            if (patients.size() < 1) {
                log.error("There is no patients available ");
                throw new PatientNotFoundException("There is no patient available ");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return patients;
    }

    public Patient findByPatientId(int patientId) {
        return patientRepository.findById(patientId);
    }

    public Patient updatePatientDependents(int patientId) {


        Patient patient = patientRepository.findById(patientId);
        List<PatientDependents> patientDependent = patientDependentsRepository.getAllDependents(patientId);
        patient.getDependentMember().addAll(patientDependent);
        patientRepository.save(patient);

        return patient;

    }
}
