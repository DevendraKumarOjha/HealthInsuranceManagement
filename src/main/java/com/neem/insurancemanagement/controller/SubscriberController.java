package com.neem.insurancemanagement.controller;

import com.neem.insurancemanagement.dto.SubscriberRequestDto;
import com.neem.insurancemanagement.entity.Subscriber;
import com.neem.insurancemanagement.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<List<Subscriber>> createSubscriber(@RequestBody SubscriberRequestDto subscriber) {
        List<Subscriber> createdSubscriber = subscriberService.createSubscriber(subscriber);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubscriber);
    }

    @PutMapping("/update-for-deductible")
    public ResponseEntity<String> updateSubscribersForDeductibleChange(@RequestParam double newDeductible) {
        subscriberService.updateAllSubscribersForDeductibleChange(newDeductible);
        return ResponseEntity.ok("Subscribers updated for deductible change.");
    }

    @GetMapping
    public ResponseEntity<List<Subscriber>> getAllSubscribers() {
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        return ResponseEntity.ok(subscribers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getSubscriberById(@PathVariable int id) {
        Optional<Subscriber> subscriber = subscriberService.getSubscriberById(id);
        return subscriber.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Subscriber> updateSubscriber(@PathVariable int id, @RequestBody Subscriber updatedSubscriber) {
        Subscriber subscriber = subscriberService.updateSubscriber(id, updatedSubscriber);
        if (subscriber != null) {
            return ResponseEntity.ok(subscriber);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
