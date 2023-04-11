package com.victormanduca.eventbooking.domain.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victormanduca.eventbooking.domain.entities.Participants;
import com.victormanduca.eventbooking.domain.usecases.IParticipants;
import com.victormanduca.eventbooking.infra.repositories.IParticipantsRepository;

@Service
public class ParticipantsImplementention implements IParticipants {

	@Autowired
	private IParticipantsRepository participantsRepository;

	@Override
	public void CreateParticipant(Participants participant) {
		participant.setId(null);
		participantsRepository.save(participant);
	}

	@Override
	public List<Participants> GetParticipants() {
		return participantsRepository.findAll();
	}
	
	@Override
	public Optional<Participants> GetParticipant(Integer id) {
		final Long idL = Long.valueOf(id);
		return participantsRepository.findById(idL);
	}
	
	@Override
	public void UpdateParticipant(Participants participant, Integer id) {
		participant.setId(id);
		participantsRepository.save(participant);
	}
	
	@Override
	public void DeleteParticipant(Integer id) {
		final Long idL = Long.valueOf(id);
		participantsRepository.deleteById(idL);
	}
}
