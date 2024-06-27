package com.rgomes.mobiauto_backend_interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.rgomes.mobiauto_backend_interview.config" // Add the package where your SecurityConfig class is located
})
public class MobiautoBackendInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobiautoBackendInterviewApplication.class, args);
	}

}
