package com.victormanduca.eventbooking.domain.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
		final int addressId = 1;
		final Address address = new Address(addressId, "1234-56", 12, "cityName", "stateName");
		final Optional<Address> optionalAddress = Optional.ofNullable(address);
		final EventDTO eventRequestBody = new EventDTO("Java Meetup", 300, addressId);
		final Event savedResponse = new Event(0, "Java Meetup", 300, address);

		Mockito.when(addressRepository.findById(addressId)).thenReturn(optionalAddress);
		Mockito.when(eventRepository.save(savedResponse)).thenReturn(savedResponse);
		eventImplementation.create(eventRequestBody);
		Mockito.verify(eventRepository, Mockito.times(1)).save(savedResponse);
	}

	@Test
	public void testCreateWithInvalidAddressId() throws Exception {
		final int addressId = 2;
		final EventDTO eventRequestBody = new EventDTO("Java Meetup", 300, addressId);

		Exception exception = assertThrows(Exception.class, () -> {
			Mockito.when(addressRepository.findById(addressId)).thenReturn(Optional.empty());
			eventImplementation.create(eventRequestBody);
		});
		assertEquals("AddressId must be valid", exception.getMessage());
	}

	@Test
	public void testGetMany() {
		final Event event = new Event();
		List<Event> listEvent = new ArrayList<Event>();
		listEvent.add(event);

		Mockito.when(eventRepository.findAll()).thenReturn(listEvent);
		List<Event> eventImplementationResponse = eventImplementation.getMany();
		Mockito.verify(eventRepository, Mockito.times(1)).findAll();

		assertTrue(eventImplementationResponse.contains(event));
	}

	@Test
	public void testGetById() {
		final int requestedId = 1;
		final Address address = new Address(requestedId, "1234-56", 12, "cityName", "stateName");
		final Optional<Event> event = Optional.ofNullable(new Event(requestedId, "Java Meetup", 300, address));
		Mockito.when(eventRepository.findById(requestedId)).thenReturn(event);

		Optional<Event> eventImplementationResponse = eventImplementation.getById(requestedId);
		Mockito.verify(eventRepository, Mockito.times(1)).findById(requestedId);

		assertTrue(eventImplementationResponse.equals(event));
	}

	@Test
	public void testUpdateById() {
		final int requestedId = 1;
		final Address address = new Address(requestedId, "1234-56", 12, "cityName", "stateName");
		final Event event = new Event(requestedId, "Java Meetup", 300, address);
		Mockito.when(eventRepository.save(event)).thenReturn(event);

		eventImplementation.updateById(requestedId, event);
		Mockito.verify(eventRepository, Mockito.times(1)).save(event);
	}

	@Test
	public void testDeleteById() {
		final int requestedId = 1;
		eventImplementation.deleteById(requestedId);
		Mockito.verify(eventRepository, Mockito.times(1)).deleteById(requestedId);
	}
}
