package com.victormanduca.eventbooking.domain.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.victormanduca.eventbooking.domain.entities.Address;
import com.victormanduca.eventbooking.domain.entities.Event;
import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.entities.dtos.EventDTO;
import com.victormanduca.eventbooking.domain.implementations.EventImplementation;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;
import com.victormanduca.eventbooking.infra.repositories.IEventRepository;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

@SpringBootTest
@ActiveProfiles("test")
public class EventImplementationTest {
	@Mock
	private IParticipantsRepository participantRepository;

	@Mock
	private IAddressRepository addressRepository;

	@Mock
	private IEventRepository eventRepository;

	@InjectMocks
	private EventImplementation eventImplementation;

	@Test
	public void testCreate() throws Exception {
		final Event savedResponse = this.getEvent();

		Mockito.when(addressRepository.findById(this.getId())).thenReturn(Optional.ofNullable(this.getAddress()));
		Mockito.when(eventRepository.save(savedResponse)).thenReturn(savedResponse);
		eventImplementation.create(this.getEventDto());

		Mockito.verify(eventRepository, Mockito.times(1)).save(savedResponse);
	}

	@Test
	public void testRegisterParticipantInEvent() throws Exception {
		final Participants participant = this.getParticipant();

		Mockito.when(participantRepository.findById(this.getId())).thenReturn(Optional.ofNullable(participant));
		Mockito.when(eventRepository.findById(this.getId())).thenReturn(Optional.ofNullable(this.getEvent()));
		Mockito.when(participantRepository.save(participant)).thenReturn(participant);

		eventImplementation.registerParticipantInEvent(this.getId(), this.getId());

		Mockito.verify(participantRepository, Mockito.times(1)).findById(this.getId());
		Mockito.verify(eventRepository, Mockito.times(1)).findById(this.getId());
		Mockito.verify(participantRepository, Mockito.times(1)).save(participant);
	}

	@Test
	public void testCreateWithInvalidAddressId() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> {
			Mockito.when(addressRepository.findById(this.getId())).thenReturn(Optional.empty());
			eventImplementation.create(this.getEventDto());
		});

		assertEquals("AddressId must be valid", exception.getMessage());
	}

	@Test
	public void testGetMany() {
		final Event event = this.getEvent();
		List<Event> listEvent = new ArrayList<>();
		listEvent.add(event);

		Mockito.when(eventRepository.findAll()).thenReturn(listEvent);
		List<Event> eventImplementationResponse = eventImplementation.getMany();
		Mockito.verify(eventRepository, Mockito.times(1)).findAll();

		assertTrue(eventImplementationResponse.contains(event));
	}

	@Test
	public void testGetById() {
		final Optional<Event> event = Optional.ofNullable(this.getEvent());
		Mockito.when(eventRepository.findById(this.getId())).thenReturn(event);

		Optional<Event> eventImplementationResponse = eventImplementation.getById(this.getId());
		Mockito.verify(eventRepository, Mockito.times(1)).findById(this.getId());

		assertTrue(eventImplementationResponse.equals(event));
	}

	@Test
	public void testUpdateById() {
		final Event event = this.getEvent();
		Mockito.when(eventRepository.save(event)).thenReturn(event);

		eventImplementation.updateById(this.getId(), event);
		Mockito.verify(eventRepository, Mockito.times(1)).save(event);
	}

	@Test
	public void testDeleteById() {
		eventImplementation.deleteById(this.getId());
		Mockito.verify(eventRepository, Mockito.times(1)).deleteById(this.getId());
	}

	private int getId() {
		return 0;
	}
	
	private String getEventName() {
		return "Java Meetup";
	}
	
	private int maxParticipants() {
		return 300;
	}

	private Address getAddress() {
		return new Address(this.getId(), "1234-56", 12, "cityName", "stateName");
	}

	private Event getEvent() {
		return new Event(this.getId(), this.getEventName(), this.maxParticipants(), this.getAddress(), new HashSet<Participants>());
	}

	private Participants getParticipant() {
		return new Participants(this.getId(), "Victor", "123-489", new HashSet<Event>());
	}

	private EventDTO getEventDto() {
		return new EventDTO(this.getEventName(), this.maxParticipants(), this.getId());
	}
}
