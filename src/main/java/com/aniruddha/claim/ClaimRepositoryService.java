package com.aniruddha.claim;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ClaimRepositoryService {
	
	 @Autowired
	    private ClaimRepository claimRepository;

	    public Claim createClaim(Claim claim) {
	        return claimRepository.save(claim);
	    }

	    public Claim updateClaim(Claim claim) {
	        return claimRepository.save(claim);
	    }

	    public void deleteClaim(Long id) {
	        claimRepository.deleteById(id);
	    }

	    public List<Claim> getAllClaims() {
	        return claimRepository.findAll();
	    }

	    public Optional<Claim> getClaimById(Long id) {
	        return claimRepository.findById(id);
	    }
	}


