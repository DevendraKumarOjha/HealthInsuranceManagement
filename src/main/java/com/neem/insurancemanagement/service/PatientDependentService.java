package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.PatientDependentDto;
import com.neem.insurancemanagement.dto.PatientRequestDto;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.entity.PatientDependents;
import com.neem.insurancemanagement.exception.PatientDependentNotFoundException;
import com.neem.insurancemanagement.exception.PatientNotFoundException;
import com.neem.insurancemanagement.repository.PatientDependentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class PatientDependentService {
    @Autowired
    PatientDependentsRepository patientDependentsRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PatientDependents createPatientDependent(PatientDependentDto requestDto) throws ParseException {
        PatientDependents patientDependent = new PatientDependents();
        patientDependent.setFirstName(requestDto.getFirstName());
        patientDependent.setLastName(requestDto.getLastName());
        patientDependent.setDateOfBirth(sdf.parse(String.valueOf(requestDto.getDateOfBirth())));
        patientDependent.setGender(requestDto.getGender());
        patientDependent.setAge(requestDto.getAge());
        patientDependent.setPatientId(requestDto.getPatientId());

        patientDependentsRepository.save(patientDependent);

        if (patientDependent.getPatientId() > -1) {
            return patientDependent;
        } else {
            log.error("A problem occurred during creating patient");
            throw new PatientDependentNotFoundException("A problem occurred during creating patient");
        }
    }


    public List<PatientDependents> findAllPatientDependents() throws Exception {
        List<PatientDependents> patientDependents = patientDependentsRepository.findAll();
        try {

            if (patientDependents.size() < 1) {
                log.error("There is no patients available ");
                throw new PatientNotFoundException("There is no patient available ");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return patientDependents;
    }

    public PatientDependents findPatientDependentByPatientId(int patientId) {
        return patientDependentsRepository.findByDependentId(patientId);
    }
}
