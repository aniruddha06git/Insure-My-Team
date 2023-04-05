package com.aniruddha.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.insurancemanagementplatform.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
}
