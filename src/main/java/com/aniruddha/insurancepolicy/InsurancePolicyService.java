package com.aniruddha.insurancepolicy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsurancePolicyService {
	@Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public void deleteInsurancePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }

    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }

    public Optional<InsurancePolicy> getInsurancePolicyById(Long id) {
        return insurancePolicyRepository.findById(id);
    }
}


