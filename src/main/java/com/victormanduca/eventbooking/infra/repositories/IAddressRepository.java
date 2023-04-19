package com.victormanduca.eventbooking.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormanduca.eventbooking.domain.entities.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
