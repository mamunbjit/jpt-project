package jpt.mamun.main;


import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "jpt.mamun.main.model")
public class JptProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(JptProjectApplication.class, args);
	}
}