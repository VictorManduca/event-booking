package com.victormanduca.eventbooking.domain.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.victormanduca.eventbooking.domain.entities.Address;
import com.victormanduca.eventbooking.domain.entities.Event;
import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.entities.dtos.EventDTO;
import com.victormanduca.eventbooking.domain.usecases.IEvent;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;
import com.victormanduca.eventbooking.infra.repositories.IEventRepository;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

@Component
public class EventImplementation implements IEvent {
	private final IEventRepository eventRepository;
	private final IAddressRepository addressRepository;
	private final IParticipantsRepository participantRepository;

	public EventImplementation(IEventRepository eventRepository, IAddressRepository addressRepository,
			IParticipantsRepository participantRepository) {
		this.eventRepository = eventRepository;
		this.addressRepository = addressRepository;
		this.participantRepository = participantRepository;
	}

	public void create(EventDTO eventDto) throws Exception {
		final Optional<Address> address = this.addressRepository.findById(eventDto.getAddressId());
		if (!address.isPresent()) {
			throw new Exception("AddressId must be valid");
		}

		final Event event = new Event();
		event.setMaxParticipants(eventDto.getMaxParticipants());
		event.setName(eventDto.getName());
		event.setAddress(address.get());
		this.eventRepository.save(event);
	}

	public List<Event> getMany() {
		return this.eventRepository.findAll();
	}

	public Optional<Event> getById(int id) {
		return this.eventRepository.findById(id);
	}

	public void updateById(int id, Event event) {
		event.setId(id);
		this.eventRepository.save(event);
	}

	public void deleteById(int id) {
		this.eventRepository.deleteById(id);
	}

	public void registerParticipantInEvent(int participantId, int eventId) throws Exception {
		Participants participant = participantRepository.findById(participantId).get();
		Event event = eventRepository.findById(eventId).get();

		participant.getParticipantEvents().add(event);
		event.getParticipants().add(participant);

		participantRepository.save(participant);
	}
}
