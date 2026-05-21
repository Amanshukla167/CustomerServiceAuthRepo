package com.aman.ekartauthservice.customerRepo;

import com.aman.ekartauthservice.customerEntity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address , Integer> {


}
