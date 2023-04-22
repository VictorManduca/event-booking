package com.victormanduca.eventbooking.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormanduca.eventbooking.domain.entities.Event;

public interface IEventRepository extends JpaRepository<Event, Integer> {

}
