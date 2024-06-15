package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.InsuranceRequestDto;
import com.neem.insurancemanagement.entity.Insurance;
import com.neem.insurancemanagement.exception.InsuranceNotFoundException;
import com.neem.insurancemanagement.repository.InsuranceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Insurance createInsurance(InsuranceRequestDto insuranceRequestDto) throws ParseException {

        Insurance insurance = new Insurance();

        insurance.setInsurancePlanName(insuranceRequestDto.getInsurancePlanName());
        insurance.setInsurancePlanNumber(insuranceRequestDto.getInsurancePlanNumber());
        insurance.setInsuranceType(insuranceRequestDto.getInsuranceType());
        insurance.setInsurancePlanStatus(insuranceRequestDto.getInsurancePlanStatus());
        insurance.setInsuranceFeeScheduler(insuranceRequestDto.getInsuranceFeeScheduler());
        insurance.setInsuranceNetworkStatus(insuranceRequestDto.getInsuranceNetworkStatus());
        insurance.setInsurancePlanNotes(insuranceRequestDto.getInsurancePlanNotes());

        insuranceRepository.save(insurance);
        if (insurance.getInsuranceId() > -1) {
            return insurance;
        } else {
            log.error("A problem occurred during creating patient");
            throw new InsuranceNotFoundException("A problem occurred during creating patient");
        }
    }

    public List<Insurance> findAllInsurances() throws Exception {
        List<Insurance> Insurances = insuranceRepository.findAll();
        try {

            if (Insurances.size() < 1) {
                log.error("There is no insurance available ");
                throw new InsuranceNotFoundException("There is no insurance available ");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return Insurances;
    }

    public Insurance findByInsuranceId(int insuranceId) {
        return insuranceRepository.findById(insuranceId);
    }
}
