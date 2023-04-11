package com.victormanduca.eventbooking.presentention;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/participants")
public class ParticipantsController implements IParticipants {
	
	@Autowired
	private ParticipantsImplementention implementation;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void CreateParticipant(@RequestBody Participants participant) {
		implementation.CreateParticipant(participant);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Participants> GetParticipants() {
		return implementation.GetParticipants();
	}
	
	@GetMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Participants> GetParticipant(@PathVariable Integer id) {
		return implementation.GetParticipant(id);
	}
	
	@PutMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void UpdateParticipant(@RequestBody Participants participant, @PathVariable Integer id) {
		implementation.UpdateParticipant(participant, id);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void DeleteParticipant(@PathVariable Integer id) {
		implementation.DeleteParticipant(id);
	}
}
