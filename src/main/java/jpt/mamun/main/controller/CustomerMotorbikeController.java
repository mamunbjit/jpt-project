package jpt.mamun.main.controller;

import org.springframework.web.bind.annotation.*;
import jpt.mamun.main.repository.CustomerMotorbikeRepository;
import jpt.mamun.main.entity.CustomerMotorbike;
import jpt.mamun.main.exception.MotorbikeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jpt.mamun.main.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/customer-motorbikes")
public class CustomerMotorbikeController {

    private final CustomerMotorbikeRepository customerMotorbikeRepository;

    @Autowired
    public CustomerMotorbikeController(CustomerMotorbikeRepository customerMotorbikeRepository) {
        this.customerMotorbikeRepository = customerMotorbikeRepository;
    }

    // Create a new CustomerMotorbike
    @PostMapping
    public ResponseEntity<CustomerMotorbike> createCustomerMotorbike(@RequestBody CustomerMotorbike customerMotorbike) {
        CustomerMotorbike savedCustomerMotorbike = customerMotorbikeRepository.save(customerMotorbike);
        return ResponseEntity.ok(savedCustomerMotorbike);
    }

    // Retrieve all CustomerMotorbikes
    @GetMapping
    public ResponseEntity<List<CustomerMotorbike>> getAllCustomerMotorbikes() {
        List<CustomerMotorbike> customerMotorbikes = customerMotorbikeRepository.findAll();
        return ResponseEntity.ok(customerMotorbikes);
    }

    // Retrieve a single CustomerMotorbike by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerMotorbike> getCustomerMotorbikeById(@PathVariable Long id) {
        CustomerMotorbike customerMotorbike = customerMotorbikeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerMotorbike not found with id: " + id));
        return ResponseEntity.ok(customerMotorbike);
    }

    // Update a CustomerMotorbike by ID
    @PutMapping("/{id}")
    public ResponseEntity<CustomerMotorbike> updateCustomerMotorbike(@PathVariable Long id, @RequestBody CustomerMotorbike updatedCustomerMotorbike) {
        CustomerMotorbike existingCustomerMotorbike = customerMotorbikeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerMotorbike not found with id: " + id));
        // Update the properties of the CustomerMotorbike entity as needed

        CustomerMotorbike savedCustomerMotorbike = customerMotorbikeRepository.save(existingCustomerMotorbike);
        return ResponseEntity.ok(savedCustomerMotorbike);
    }

    // Delete a CustomerMotorbike by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerMotorbike(@PathVariable Long id) {
        if (customerMotorbikeRepository.existsById(id)) {
            customerMotorbikeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("CustomerMotorbike not found with id: " + id);
        }
    }
}




//
//@RestController
//@RequestMapping("/api/customer-motorbikes")
//public class CustomerMotorbikeController {
//    private final CustomerMotorbikeRepository customerMotorbikeRepository;
//
//    @Autowired
//    public CustomerMotorbikeController(CustomerMotorbikeRepository customerMotorbikeRepository) {
//        this.customerMotorbikeRepository = customerMotorbikeRepository;
//    }
//
//    // Implement operations to manage customer-motorbike relationships
//}