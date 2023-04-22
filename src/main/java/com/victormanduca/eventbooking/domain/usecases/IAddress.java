package com.victormanduca.eventbooking.domain.usecases;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Address;

public interface IAddress {
	void create(Address address);

	List<Address> getMany();

	Optional<Address> getById(int id);

	void updateById(int id, Address address);
}
