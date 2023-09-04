package jpt.mamun.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jpt.mamun.main.model.Motorbike;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
}
