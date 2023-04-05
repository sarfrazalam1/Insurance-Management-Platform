package com.policy.insurance.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.policy.insurance.dao.PolicyRepository;
import com.policy.insurance.entities.Policy;

@Component
public class PolicyServices {
	
	@Autowired
	private PolicyRepository policyRepository;

	//get all books
	public List<Policy> getAllPolicy(){ 
		List<Policy> list = (List<Policy>)this.policyRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Policy getPolicyById(int id) {
		Policy policy =null;
		try {
			policy = this.policyRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return policy;
	}
	
	//adding the book
	public Policy addPolicy(Policy p) {
		Policy result =policyRepository.save(p);
		return result;
	}
 
	//delete book
	public void deletePolicy(int pid) {
		policyRepository.deleteById(pid);
	}
	
	//update book
	public void updatePolicy(Policy policy, int policyId) {
		policy.setPolicyNumber(policyId);
		policyRepository.save(policy);
	}
	

}
