package com.insurancemanagement.controller;

import java.security.Policy;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

	@GetMapping("/api/policies")
	public List<Policy> getAllPolicies() {
	return policyService.getAllPolicies();
	}
	@GetMapping("/api/policies/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
	Policy policy = policyService.getPolicyById(id);
	if (policy == null) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(policy);
	}
	@PostMapping("/api/policies")
	public Policy createPolicy(@RequestBody Policy policy) {
	return policyService.createPolicy(policy);
	}
	@PutMapping("/api/policies/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
	Policy updatedPolicy = policyService.updatePolicy(id, policy);
	if (updatedPolicy == null) {
	return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(updatedPolicy);
	}
	@DeleteMapping("/api/policies/{id}")
	public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
	policyService.deletePolicy(id);
	return ResponseEntity.noContent().build();
	}
	
	
}