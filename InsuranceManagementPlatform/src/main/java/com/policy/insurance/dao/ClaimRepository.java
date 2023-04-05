package com.policy.insurance.dao;

import org.springframework.data.repository.CrudRepository;

import com.policy.insurance.entities.Claim;

public interface ClaimRepository extends CrudRepository<Claim, Integer> {
	public Claim findById(int id);

}
