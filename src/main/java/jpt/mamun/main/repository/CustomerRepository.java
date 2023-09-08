package jpt.mamun.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpt.mamun.main.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

