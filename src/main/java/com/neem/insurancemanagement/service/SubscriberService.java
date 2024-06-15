package com.neem.insurancemanagement.service;

import com.neem.insurancemanagement.dto.SubscriberRequestDto;
import com.neem.insurancemanagement.entity.Patient;
import com.neem.insurancemanagement.entity.PatientDependents;
import com.neem.insurancemanagement.repository.PatientDependentsRepository;
import com.neem.insurancemanagement.repository.PatientRepository;
import com.neem.insurancemanagement.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neem.insurancemanagement.entity.Subscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientDependentsRepository patientDependentsRepository;

    public Optional<Subscriber> getSubscriberById(int id) {
        return subscriberRepository.findById(id);
    }

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public List<Subscriber> createSubscriber(SubscriberRequestDto subscriberDto) {
        List<Subscriber> subscribersList = new ArrayList<>();

        Patient patient = patientRepository.findById(subscriberDto.getPatientId());

        List<PatientDependents> dependents = patientDependentsRepository.getAllDependents(patient.getId());

        Subscriber subscriber = new Subscriber();
        subscriber.setPatientId(patient.getId());//we will do mapping at database level.
        subscriber.setFirstName(patient.getFirstName());
        subscriber.setSecondName(patient.getLastName());
        subscriber.setDeductible(subscriberDto.getDeductible());

        subscribersList.add(subscriber);

        for (PatientDependents dependent : dependents) {
            Subscriber dependentSubscriber = new Subscriber();
            dependentSubscriber.setPatientId(patient.getId());
            dependentSubscriber.setFirstName(dependent.getFirstName());
            dependentSubscriber.setSecondName(dependent.getLastName());
            dependentSubscriber.setDependentId(dependent.getDependentId());
            dependentSubscriber.setDeductible(subscriberDto.getDeductible());
            subscribersList.add(dependentSubscriber);
        }

        return subscriberRepository.saveAll(subscribersList);
    }

    @Transactional
    public void updateAllSubscribersForDeductibleChange(double newDeductible) {

        List<Subscriber> subscribersToUpdate = subscriberRepository.findByDeductible(newDeductible);
        for (Subscriber subscriber : subscribersToUpdate) {
            subscriber.setDeductible(newDeductible);
        }
        subscriberRepository.saveAll(subscribersToUpdate);
    }

    public Subscriber updateSubscriber(int id, Subscriber updatedSubscriber) {
        if (subscriberRepository.existsById(id)) {
            updatedSubscriber.setSubscriberId(id);
            return subscriberRepository.save(updatedSubscriber);
        } else {
            return null; // or we can throw exception
        }
    }
}
