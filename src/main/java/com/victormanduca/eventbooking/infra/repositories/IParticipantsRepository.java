package com.victormanduca.eventbooking.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormanduca.eventbooking.domain.entities.Participants;

public interface IParticipantsRepository extends JpaRepository<Participants, Long> {

}