package com.victormanduca.eventbooking.config.address;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.victormanduca.eventbooking.domain.implementations.AddressImplementation;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;

@Configuration
@ComponentScan("config.address")
public class AddressConfig {

	@Bean
	public AddressImplementation addressImplementation(IAddressRepository repository) {
		return new AddressImplementation(repository);
	}
}
