package com.victormanduca.eventbooking.domain.implementations;

import java.util.List;
import java.util.Optional;

import com.victormanduca.eventbooking.domain.entities.Address;
import com.victormanduca.eventbooking.domain.usecases.IAddress;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;

public class AddressImplementation implements IAddress {
	private final IAddressRepository repository;

	public AddressImplementation(IAddressRepository repository) {
		this.repository = repository;
	}

	public void create(Address address) {
		address.setId(null);
		repository.save(address);
	}
	
	public List<Address> getMany() {
		return repository.findAll();
	}
	
	public Optional<Address> getById(Integer id) {
		return repository.findById(id);
	}
	
	public void updateById(Integer id, Address address) {
		address.setId(id);
		repository.save(address);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
}
