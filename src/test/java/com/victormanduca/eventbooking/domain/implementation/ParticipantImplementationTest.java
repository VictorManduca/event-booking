package com.victormanduca.eventbooking.domain.implementation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.victormanduca.eventbooking.domain.entities.Event;
import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.implementations.ParticipantsImplementention;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ParticipantImplementationTest {
	@Mock
	private IParticipantsRepository participantRepository;

	@InjectMocks
	private ParticipantsImplementention participantImplementation;

	@Test
	public void testCreate() {
		final Participants participant = this.getParticipant();
		Mockito.when(participantRepository.save(participant)).thenReturn(participant);
		participantImplementation.create(participant);

		Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
	}

	@Test
	public void testGetMany() {
		final Participants participant = this.getParticipant();
		List<Participants> listParticipant = new ArrayList<>();
		listParticipant.add(participant);

		Mockito.when(participantRepository.findAll()).thenReturn(listParticipant);
		List<Participants> participantImplementationResponse = participantImplementation.getMany();

		Mockito.verify(participantRepository, Mockito.times(1)).findAll();
		assertTrue(participantImplementationResponse.contains(participant));
	}

	@Test
	public void testGetById() {
		final Set<Event> events = new HashSet<>();
		events.add(this.getEvent());

		final Optional<Participants> participant = Optional.ofNullable(this.getParticipant(events));

		Mockito.when(participantRepository.findById(this.getId())).thenReturn(participant);
		Optional<Participants> participantImplementationResponse = participantImplementation.getById(this.getId());

		Mockito.verify(participantRepository, Mockito.times(1)).findById(this.getId());
		assertTrue(participantImplementationResponse.equals(participant));
	}

	@Test
	public void testUpdateById() {
		final Participants participant = this.getParticipant();
		Mockito.when(participantRepository.save(participant)).thenReturn(participant);

		participantImplementation.updateById(this.getId(), participant);
		Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
	}

	@Test
	public void testDeleteById() {
		participantImplementation.deleteById(this.getId());
		Mockito.verify(participantRepository, Mockito.times(1)).deleteById(this.getId());
	}

	private int getId() {
		return 1;
	}
	 
	private String getParticipantName() {
		return "Victor";
	}
	
	private String getParticipantDocument() {
		return "123-489";
	}

	private Participants getParticipant() {
		return new Participants(this.getId(), this.getParticipantName(), this.getParticipantDocument());
	}

	private Participants getParticipant(Set<Event> events) {
		return new Participants(this.getId(), this.getParticipantName(), this.getParticipantDocument(), events);
	}

	private Event getEvent() {
		return new Event();
	}
}
