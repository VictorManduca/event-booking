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
		final Address address = this.address();
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		addressImplementation.create(address);

		Mockito.verify(addressRepository, Mockito.times(1)).save(address);
	}

	@Test
	public void testGetMany() {
		final Address address = this.address();
		List<Address> listAddress = new ArrayList<>();
		listAddress.add(address);

		Mockito.when(addressRepository.findAll()).thenReturn(listAddress);
		List<Address> addressImplementationResponse = addressImplementation.getMany();
		Mockito.verify(addressRepository, Mockito.times(1)).findAll();

		assertTrue(addressImplementationResponse.contains(address));
	}

	@Test
	public void testGetById() {
		final Optional<Address> address = Optional.ofNullable(this.address());
		Mockito.when(addressRepository.findById(this.requestId())).thenReturn(address);

		Optional<Address> addressImplementationResponse = addressImplementation.getById(this.requestId());
		Mockito.verify(addressRepository, Mockito.times(1)).findById(this.requestId());

		assertTrue(addressImplementationResponse.equals(address));
	}

	@Test
	public void testUpdateById() {
		final Address address = this.address();
		Mockito.when(addressRepository.save(address)).thenReturn(address);

		addressImplementation.updateById(this.requestId(), address);
		Mockito.verify(addressRepository, Mockito.times(1)).save(address);
	}

	@Test
	public void testDeleteById() {
		addressImplementation.deleteById(this.requestId());
		Mockito.verify(addressRepository, Mockito.times(1)).deleteById(this.requestId());
	}

	private Address address() {
		return new Address(this.requestId(), "1234-56", 12, "cityName", "stateName");
	}
	
	private int requestId() {
		return 1;
	}
}