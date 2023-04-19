package com.victormanduca.eventbooking.domain.usecases;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Participants;

public interface IParticipants {
	void create(Participants participant);

	List<Participants> getMany();

	Optional<Participants> getById(Integer id);

	void updateById(Integer id, Participants participant);

	void deleteById(Integer id);
}
