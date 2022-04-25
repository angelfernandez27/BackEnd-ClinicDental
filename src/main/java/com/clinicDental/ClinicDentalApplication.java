package com.clinicDental;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicDentalApplication {
	private static final Logger logger=Logger.getLogger(ClinicDentalApplication.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicDentalApplication.class, args);
	}

}
