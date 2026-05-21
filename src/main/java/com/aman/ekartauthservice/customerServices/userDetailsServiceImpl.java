package com.aman.ekartauthservice.customerServices;

import com.aman.ekartauthservice.customerEntity.Customer;
import com.aman.ekartauthservice.customerRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
 public class userDetailsServiceImpl  implements UserDetailsService {

     @Autowired
    private CustomerRepo CustomerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Customer> customerObj = CustomerRepo.findBycustomerEmailID(email);

        Customer customer = customerObj.orElseThrow(() -> new UsernameNotFoundException("the User Does not exist, please try with diffrent ID"));




        return User.builder()
                .password(customer.getPassword())
                .username(customer.getCustomerName())
                .roles(customer.getRole().name())
                .build();
    };

 }