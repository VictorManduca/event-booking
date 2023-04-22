package com.victormanduca.eventbooking.config.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.victormanduca.eventbooking.domain.implementations.EventImplementation;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;
import com.victormanduca.eventbooking.infra.repositories.IEventRepository;

@Configuration
@ComponentScan("config.event")
public class EventConfig {

	@Bean
	public EventImplementation eventImplementention(IEventRepository eventRepository, IAddressRepository addressRepository) {
		return new EventImplementation(eventRepository, addressRepository);
	}
}
