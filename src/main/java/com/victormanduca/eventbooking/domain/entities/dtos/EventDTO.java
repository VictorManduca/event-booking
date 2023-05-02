package com.victormanduca.eventbooking.domain.entities.dtos;

import java.io.Serializable;

public record EventDTO (String name, int maxParticipants, int addressId) {}
