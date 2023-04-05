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

import com.policy.insurance.entities.Claim;
import com.policy.insurance.services.ClaimServices;

@RestController
public class ClaimController {

	@Autowired
	public ClaimServices claimservices;
	
	//get all the claims
	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> getClaims() {
		
		List<Claim> list=claimservices.getAllClaim();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
     	return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//get single claim 
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> getClaim(@PathVariable("id") int id) {
		
		Claim claim = claimservices.getClaimById(id);
		
		if(claim==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(claim));
	}
	
	//add claim
	@PostMapping("/claims")
	public ResponseEntity <Claim> addClaim(@RequestBody Claim claim) {
	     Claim c = null;
	     try {
	    	 c = this.claimservices.addClaim(claim);
             System.out.println(claim);
             return ResponseEntity.status(HttpStatus.CREATED).build();
	     }catch (Exception e) {
	    	 e.printStackTrace();
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	 
	     }           
	    
	}
	
	//delete Claim handler
	@DeleteMapping("/claims/{claimId}")
	public ResponseEntity<Void> deleteClaim(@PathVariable("claimId") int claimId) {
		
		try {
			this.claimservices.deleteClaim(claimId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	//update claim handler
	@PutMapping("/claim/{claimId}")
	public ResponseEntity <Claim> updateClaim(@RequestBody Claim claim,@PathVariable("claimId") int claimId)
	{
		try {
			this.claimservices.updateClaim(claim, claimId);
			return ResponseEntity.ok().body(claim);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	
	}
}
