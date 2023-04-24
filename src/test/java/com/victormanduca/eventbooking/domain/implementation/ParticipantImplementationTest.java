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
		final Participants participant = new Participants();
		Mockito.when(participantRepository.save(participant)).thenReturn(participant);
		participantImplementation.create(participant);
		Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
	}

	@Test
	public void testGetMany() {
		final Participants participant = new Participants();
		List<Participants> listParticipant = new ArrayList<Participants>();
		listParticipant.add(participant);

		Mockito.when(participantRepository.findAll()).thenReturn(listParticipant);
		List<Participants> participantImplementationResponse = participantImplementation.getMany();
		Mockito.verify(participantRepository, Mockito.times(1)).findAll();

		assertTrue(participantImplementationResponse.contains(participant));
	}

	@Test
	public void testGetById() {
		final int requestedId = 1;
		final Set<Event> events = new HashSet<Event>();
		events.add(new Event());
		final Optional<Participants> participant = Optional
				.ofNullable(new Participants(requestedId, "Victor", "123-489", events));
		Mockito.when(participantRepository.findById(requestedId)).thenReturn(participant);

		Optional<Participants> participantImplementationResponse = participantImplementation.getById(requestedId);
		Mockito.verify(participantRepository, Mockito.times(1)).findById(requestedId);

		assertTrue(participantImplementationResponse.equals(participant));
	}

	@Test
	public void testUpdateById() {
		final int requestedId = 1;
		final Participants participant = new Participants(requestedId, "Victor", "123-489");
		Mockito.when(participantRepository.save(participant)).thenReturn(participant);

		participantImplementation.updateById(requestedId, participant);
		Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
	}

	@Test
	public void testDeleteById() {
		final int requestedId = 1;
		participantImplementation.deleteById(requestedId);
		Mockito.verify(participantRepository, Mockito.times(1)).deleteById(requestedId);
	}
}
