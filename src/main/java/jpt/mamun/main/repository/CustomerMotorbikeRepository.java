package jpt.mamun.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpt.mamun.main.entity.CustomerMotorbike;


public interface CustomerMotorbikeRepository extends JpaRepository<CustomerMotorbike, Long> {
    // Custom query methods (if needed)
}


