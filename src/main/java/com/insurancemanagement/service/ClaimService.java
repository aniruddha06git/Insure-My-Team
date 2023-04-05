package com.insurancemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.insurancemanagement.exception.InvalidInputException;
import com.insurancemanagement.exception.MissingDataException;
import com.insurancemanagement.model.Claim;
import com.insurancemanagement.repository.ClaimRepository;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    public Claim createClaim(Claim claim) {
        validateClaim(claim);
        return claimRepository.save(claim);
    }

    public Claim updateClaim(Long id, Claim claim) {
        validateClaim(claim);
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            claim.setId(id);
            return claimRepository.save(claim);
        }
        return null;
    }

    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
    
    private void validateClaim(Claim claim) {
        if (StringUtils.isEmpty(claim.getDescription())) {
            throw new MissingDataException("Description is missing");
        }
        if (claim.getInsurancePolicy() == null) {
            throw new MissingDataException("Insurance policy is missing");
        }
    }
}


