package com.geeksHub.dev;

import com.geeksHub.dev.repositories.CompanyRepository;
import com.geeksHub.dev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class DevApplication implements CommandLineRunner {

	@Autowired
	private CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save a couple of customers
//		companyRepository.save(new Company("Valeo", "Smart village"));
//		companyRepository.save(new Company("Vodafone", "Smart village"));

	}

}
