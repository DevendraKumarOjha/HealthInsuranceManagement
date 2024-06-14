package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.controller.InsuranceCarrierController;
import com.neem.insurancemanagement.dto.InsuranceCarrierDto;
import com.neem.insurancemanagement.entity.Insurance;
import com.neem.insurancemanagement.entity.InsuranceCarrier;
import com.neem.insurancemanagement.exception.InsuranceCarrierNotFoundException;
import com.neem.insurancemanagement.exception.InsuranceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neem.insurancemanagement.repository.InsuranceCarrierRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InsuranceCarrierService {
    @Autowired
    InsuranceCarrierRepository insuranceCarrierRepository;

    public InsuranceCarrier createInsuranceCarrier(InsuranceCarrierDto insuranceCarrierDto) {

        InsuranceCarrier insuranceCarrier = new InsuranceCarrier();

      // List<Insurance> carrierInsuranceRequests = insuranceCarrierDto.getInsurance();
       /*List<Insurance>insuranceList = new ArrayList<>();

       for(Insurance carrierInsuranceRequest:carrierInsuranceRequests){
           Insurance insurance= new Insurance();
           insurance.setInsurancePlanName(carrierInsuranceRequest.getInsurancePlanName());
           insurance.setInsurancePlanNumber(carrierInsuranceRequest.getInsurancePlanNumber());
           insurance.setInsuranceType(carrierInsuranceRequest.getInsuranceType());
           insurance.setInsuranceNetworkStatus(carrierInsuranceRequest.getInsuranceNetworkStatus());
           insurance.setInsurancePlanStatus(carrierInsuranceRequest.getInsurancePlanStatus());
           insurance.setInsuranceFeeScheduler(carrierInsuranceRequest.getInsuranceFeeScheduler());
           insurance.setInsurancePlanNotes(carrierInsuranceRequest.getInsurancePlanNotes());
           insuranceList.add(insurance);
       }*/


        insuranceCarrier.setCarrierName(insuranceCarrierDto.getCarrierName());
        insuranceCarrier.setPhoneNumber(insuranceCarrierDto.getPhoneNumber());
        insuranceCarrier.setCity(insuranceCarrierDto.getCity());
        insuranceCarrier.setState(insuranceCarrierDto.getState());
        insuranceCarrier.setZip(insuranceCarrierDto.getZip());
        //insuranceCarrier.setInsurance(insuranceList);

        return insuranceCarrierRepository.save(insuranceCarrier);

    }

    public List<InsuranceCarrier> findAllInsuranceCarriers() throws Exception {
        List<InsuranceCarrier> insuranceCarriers =  insuranceCarrierRepository.findAll();

        try {

            if (insuranceCarriers.size() < 1) {
                log.error("There is no insurance Carrier available ");
                throw new InsuranceCarrierNotFoundException("There is no insurance carrier available ");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

        return insuranceCarriers;

    }

    public InsuranceCarrier findByInsuranceCarrierId(int carrierId) {
        return insuranceCarrierRepository.findById(carrierId);
    }
}
