package com.insurancemanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddha.claim.Claim;

@RestController
public class ClaimController {
	@GetMapping("/api/claims")
	public List<Claim> getAllClaims() {
	    return claimService.getAllClaims();
	}

	@GetMapping("/api/claims/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
	    Claim claim = claimService.getClaimById(id);
	    if (claim == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(claim);
	}

	@PostMapping("/api/claims")
	public Claim createClaim(@RequestBody Claim claim) {
	    return claimService.createClaim(claim);
	}

	@PutMapping("/api/claims/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
	    Claim updatedClaim = claimService.updateClaim(id, claim);
	    if (updatedClaim == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(updatedClaim);
	}

	@DeleteMapping("/api/claims/{id}")
	public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
	    claimService.deleteClaim(id);
	    return ResponseEntity.noContent().build();
	}

	

}
