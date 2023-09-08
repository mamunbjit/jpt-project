package jpt.mamun.main.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "jpt.mamun.main.entity")
public class JptProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JptProjectApplication.class, args);
    }
}
