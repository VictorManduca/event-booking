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

import com.victormanduca.eventbooking.domain.entities.Address;
import com.victormanduca.eventbooking.domain.implementations.AddressImplementation;
import com.victormanduca.eventbooking.domain.usecases.IAddress;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/address")
public class AddressController implements IAddress {
	private final AddressImplementation implementation;

	public AddressController(AddressImplementation implementation) {
		this.implementation = implementation;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@Valid @RequestBody Address address) {
		this.implementation.create(address);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Address> getMany() {
		return this.implementation.getMany();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Address> getById(@PathVariable int id) {
		return this.implementation.getById(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateById(@PathVariable int id, @Valid @RequestBody Address address) {
		this.implementation.updateById(id, address);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(@PathVariable int id) {
		this.implementation.deleteById(id);
	}
}
