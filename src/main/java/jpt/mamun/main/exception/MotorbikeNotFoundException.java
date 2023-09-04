package jpt.mamun.main.exception;

public class MotorbikeNotFoundException extends RuntimeException {
    public MotorbikeNotFoundException(Long id) {
        super("Motorbike not found with id: " + id);
    }
}

