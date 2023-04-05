package com.aniruddha.insurancepolicy;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aniruddha.client.Client;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
	
	List<InsurancePolicy> findByClient(Client client);

    List<InsurancePolicy> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(Date startDate, Date endDate);

    @Query("SELECT COUNT(p) FROM InsurancePolicy p WHERE p.client = ?1")
    Long countByClient(Client client);
	
}
