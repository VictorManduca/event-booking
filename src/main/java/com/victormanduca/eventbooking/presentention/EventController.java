package com.victormanduca.eventbooking.presentention;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victormanduca.eventbooking.domain.entities.Event;
import com.victormanduca.eventbooking.domain.entities.dtos.EventDTO;
import com.victormanduca.eventbooking.domain.implementations.EventImplementation;
import com.victormanduca.eventbooking.domain.usecases.IEvent;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/event")
public class EventController implements IEvent {
	private final EventImplementation implementation;

	public EventController(EventImplementation implementation) {
		this.implementation = implementation;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody EventDTO event) throws Exception {
		this.implementation.create(event);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Event> getMany() {
		return this.implementation.getMany();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Event> getById(@PathVariable int id) {
		return this.implementation.getById(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateById(@PathVariable int id, @Valid @RequestBody Event event) {
		this.implementation.updateById(id, event);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable int id) {
		this.implementation.deleteById(id);
	}
}
