package com.policy.insurance.dao;

import org.springframework.data.repository.CrudRepository;

import com.policy.insurance.entities.Policy;

public interface PolicyRepository extends CrudRepository<Policy, Integer> {
	public Policy findById(int id);
}
