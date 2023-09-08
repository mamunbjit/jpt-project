

package jpt.mamun.main.controller;



import org.springframework.web.bind.annotation.*;
import jpt.mamun.main.repository.MotorbikeRepository;
import jpt.mamun.main.entity.Motorbike;
import jpt.mamun.main.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import java.util.List;



@RestController
@RequestMapping("/motorbikes")
public class MotorbikeController {

    private final MotorbikeRepository motorbikeRepository;

    @Autowired
    public MotorbikeController(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    // Create a new Motorbike
    @PostMapping
    public ResponseEntity<Motorbike> createMotorbike(@RequestBody Motorbike motorbike) {
        Motorbike savedMotorbike = motorbikeRepository.save(motorbike);
        return ResponseEntity.ok(savedMotorbike);
    }

    // Retrieve all Motorbikes
    @GetMapping
    public ResponseEntity<List<Motorbike>> getAllMotorbikes() {
        List<Motorbike> motorbikes = motorbikeRepository.findAll();
        return ResponseEntity.ok(motorbikes);
    }

    // Retrieve a single Motorbike by ID
    @GetMapping("/{id}")
    public ResponseEntity<Motorbike> getMotorbikeById(@PathVariable Long id) {
        Motorbike motorbike = motorbikeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorbike not found with id: " + id));
        return ResponseEntity.ok(motorbike);
    }

    // Update a Motorbike by ID
    @PutMapping("/{id}")
    public ResponseEntity<Motorbike> updateMotorbike(@PathVariable Long id, @RequestBody Motorbike updatedMotorbike) {
        Motorbike existingMotorbike = motorbikeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorbike not found with id: " + id));
        existingMotorbike.setBikeName(updatedMotorbike.getBikeName());
        existingMotorbike.setBrand(updatedMotorbike.getBrand());
        existingMotorbike.setColor(updatedMotorbike.getColor());

        Motorbike savedMotorbike = motorbikeRepository.save(existingMotorbike);
        return ResponseEntity.ok(savedMotorbike);
    }

    // Delete a Motorbike by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorbike(@PathVariable Long id) {
        if (motorbikeRepository.existsById(id)) {
            motorbikeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Motorbike not found with id: " + id);
        }
    }
}
