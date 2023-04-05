package com.insurancemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.insurancemanagement.exception.DatabaseException;
import com.insurancemanagement.exception.InvalidInputException;
import com.insurancemanagement.exception.MissingDataException;
import com.insurancemanagement.model.InsurancePolicy;
import com.insurancemanagement.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }

    public Optional<InsurancePolicy> getInsurancePolicyById(Long id) {
        return insurancePolicyRepository.findById(id);
    }

    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
        validateInsurancePolicy(insurancePolicy);
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy updateInsurancePolicy(Long id, InsurancePolicy insurancePolicy) {
        validateInsurancePolicy(insurancePolicy);
        Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepository.findById(id);
        if (optionalInsurancePolicy.isPresent()) {
            insurancePolicy.setId(id);
            return insurancePolicyRepository.save(insurancePolicy);
        }
        return null;
    }

    public void deleteInsurancePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }
    
    private void validateInsurancePolicy(InsurancePolicy insurancePolicy) {
        if (StringUtils.isEmpty(insurancePolicy.getPolicyNumber())) {
            throw new MissingDataException("Policy number is missing");
        }
        if (StringUtils.isEmpty(insurancePolicy.getInsuredName())) {
            throw new MissingDataException("Insured name is missing");
        }
    }

    private boolean policyExists(String policyNumber) {
        Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepository.findByPolicyNumber(policyNumber);
        return optionalInsurancePolicy.isPresent();
    }
}
