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

import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.implementations.ParticipantsImplementention;
import com.victormanduca.eventbooking.domain.usecases.IParticipants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/participants")
public class ParticipantsController implements IParticipants {
	private ParticipantsImplementention implementation;

	public ParticipantsController(ParticipantsImplementention implementation) {
		this.implementation = implementation;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Participants participant) {
		implementation.create(participant);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Participants> getMany() {
		return implementation.getMany();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Participants> getById(@PathVariable int id) {
		return implementation.getById(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateById(@PathVariable int id, @Valid @RequestBody Participants participant) {
		implementation.updateById(id, participant);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable int id) {
		implementation.deleteById(id);
	}
}
