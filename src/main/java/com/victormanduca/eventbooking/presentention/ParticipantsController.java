package com.victormanduca.eventbooking.presentention;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.usecases.IParticipants;

@RestController
public class ParticipantsController implements IParticipants {
	
	@PostMapping(path = "/participants")
	public void CreateParticipant(Participants participant) {
		return 
	}
}
