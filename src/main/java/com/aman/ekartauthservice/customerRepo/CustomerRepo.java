package com.aman.ekartauthservice.customerRepo;

import com.aman.ekartauthservice.customerEntity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {


    Optional<Customer> findBycustomerEmailID(String email);
}
