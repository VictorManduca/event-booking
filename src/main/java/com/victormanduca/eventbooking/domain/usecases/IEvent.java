package com.victormanduca.eventbooking.domain.usecases;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Event;
import com.victormanduca.eventbooking.domain.entities.dtos.EventDTO;

public interface IEvent {
	void create(EventDTO event) throws Exception;

	List<Event> getMany();

	Optional<Event> getById(int id);

	void updateById(int id, Event event);

	void deleteById(int id);
}
