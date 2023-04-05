package com.policy.insurance.dao;

import org.springframework.data.repository.CrudRepository;

import com.policy.insurance.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	public Client findById(int id);

}
