package com.victormanduca.eventbooking.domain.implementation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.victormanduca.eventbooking.domain.entities.Address;
import com.victormanduca.eventbooking.domain.implementations.AddressImplementation;
import com.victormanduca.eventbooking.infra.repositories.IAddressRepository;

@SpringBootTest
@ActiveProfiles("test")
public class AddressImplementationTest {

	@Mock
	private IAddressRepository addressRepository;

	@InjectMocks
	private AddressImplementation addressImplementation;

	@Test
	public void testCreate() {
		final Address address = new Address();
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		addressImplementation.create(address);
		Mockito.verify(addressRepository, Mockito.times(1)).save(address);
	}

	@Test
	public void testGetMany() {
		final Address address = new Address();
		List<Address> listAddress = new ArrayList<Address>();
		listAddress.add(address);

		Mockito.when(addressRepository.findAll()).thenReturn(listAddress);
		List<Address> addressImplementationResponse = addressImplementation.getMany();
		Mockito.verify(addressRepository, Mockito.times(1)).findAll();

		assertTrue(addressImplementationResponse.contains(address));
	}

	@Test
	public void testGetById() {
		final int requestedId = 1;
		final Optional<Address> address = Optional
				.ofNullable(new Address(requestedId, "1234-56", 12, "cityName", "stateName"));
		Mockito.when(addressRepository.findById(requestedId)).thenReturn(address);

		Optional<Address> addressImplementationResponse = addressImplementation.getById(requestedId);
		Mockito.verify(addressRepository, Mockito.times(1)).findById(requestedId);

		assertTrue(addressImplementationResponse.equals(address));
	}

	@Test
	public void testUpdateById() {
		final int requestedId = 1;
		final Address address = new Address(requestedId, "1234-56", 12, "cityName", "stateName");
		Mockito.when(addressRepository.save(address)).thenReturn(address);

		addressImplementation.updateById(requestedId, address);
		Mockito.verify(addressRepository, Mockito.times(1)).save(address);
	}

	@Test
	public void testDeleteById() {
		final int requestedId = 1;
		addressImplementation.deleteById(requestedId);
		Mockito.verify(addressRepository, Mockito.times(1)).deleteById(requestedId);
	}
}