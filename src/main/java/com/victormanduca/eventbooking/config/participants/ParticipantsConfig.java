package com.victormanduca.eventbooking.config.participants;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.victormanduca.eventbooking.domain.implementations.ParticipantsImplementention;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

@Configuration
@ComponentScan("config.participants")
public class ParticipantsConfig {

	@Bean
	public ParticipantsImplementention participantsImplementention(IParticipantsRepository repository) {
		return new ParticipantsImplementention(repository);
	}
}
