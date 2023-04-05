package com.policy.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.policy.insurance.entities.Policy;
import com.policy.insurance.services.PolicyServices;

@RestController
public class PolicyController {
	
	@Autowired
	public PolicyServices policyservices;
	
	//get all the policies
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getClients() {
		
		List<Policy> list=policyservices.getAllPolicy();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
     	return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get single policies 
	@GetMapping("/policies/{id}")
	public ResponseEntity<Policy> getPolicy(@PathVariable("id") int id) {
		
		Policy policy = policyservices.getPolicyById(id);
		
		if(policy==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(policy));
	}
	
	//add policies
	@PostMapping("/policies")
	public ResponseEntity <Policy> addClient(@RequestBody Policy policy) {
	     Policy p = null;
	     try {
	    	 p = this.policyservices.addPolicy(policy);
             System.out.println(policy);
             return ResponseEntity.status(HttpStatus.CREATED).build();
	     }catch (Exception e) {
	    	 e.printStackTrace();
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	 
	     }           
	    
	}
	
	//delete policies handler
	@DeleteMapping("/policies/{policiesId}")
	public ResponseEntity<Void> deletePolicy(@PathVariable("policiesId") int policyId) {
		
		try {
			this.policyservices.deletePolicy(policyId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	//update policies handler
	@PutMapping("/policies/{policiesId}")
	public ResponseEntity <Policy> updatePolicy(@RequestBody Policy policy,@PathVariable("policesId") int policyId)
	{
		try {
			this.policyservices.updatePolicy(policy, policyId);
			return ResponseEntity.ok().body(policy);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	
	}

}
