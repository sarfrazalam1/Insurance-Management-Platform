package com.policy.insurance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.policy.insurance.dao.ClaimRepository;
import com.policy.insurance.entities.Claim;

@Component
public class ClaimServices {
	
	@Autowired
	private ClaimRepository claimRepository;

	//get all books
	public List<Claim> getAllClaim(){ 
		List<Claim> list = (List<Claim>)this.claimRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Claim getClaimById(int id) {
		Claim claim =null;
		try {
			claim = this.claimRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return claim;
	}
	
	//adding the book
	public Claim addClaim(Claim c) {
		Claim result =claimRepository.save(c);
		return result;
	}
 
	//delete book
	public void deleteClaim(int cid) {
		claimRepository.deleteById(cid);
	}
	
	//update book
	public void updateClaim(Claim claim, int claimId) {
		claim.setClaimNumber(claimId);
		claimRepository.save(claim);
	}
	

}
