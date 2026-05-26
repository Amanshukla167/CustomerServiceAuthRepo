package com.aman.ekartauthservice.customerServices;

import com.aman.ekartauthservice.customerDTO.AddressDTO;
import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.customerEntity.Address;
import com.aman.ekartauthservice.customerEntity.Customer;
import com.aman.ekartauthservice.customerRepo.CustomerRepo;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class adminCustomerManageServicesImpl implements AdminCustomerManageServices {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO getCustomerDetail(String email) throws EkartExecption {

        List<AddressDTO> addressDTOList = new ArrayList<>();

       Optional<Customer> custObj =  customerRepo.findBycustomerEmailID(email);
       Customer customer = custObj.orElseThrow(()-> new  EkartExecption("The customer does not exist please try with diffrent email id"));

       CustomerDTO customerDTO = new CustomerDTO();

       customerDTO.setCustID(customer.getCustID());
       customerDTO.setCustomerName(customer.getCustomerName());
       customerDTO.setCustomerEmailID(customer.getCustomerEmailID());
       customerDTO.setCustomerPhoneNo(customer.getCustomerPhoneNo());
       customerDTO.setDOB(customer.getDOB());
       customerDTO.setRole(customer.getRole());

         List<Address> addresses = customer.getAddress();

         for(Address address : addresses){

             AddressDTO addressDTO = new AddressDTO();

             addressDTO.setAddressID(address.getAddressID());
             addressDTO.setHousNo(address.getHousNo());
             addressDTO.setCity(address.getCity());
             addressDTO.setDristric(address.getDristric());
             addressDTO.setPinCode(address.getPinCode());
             addressDTO.setState(address.getState());

             addressDTOList.add(addressDTO);
         }

         customerDTO.setAddress(addressDTOList);


        return customerDTO;
    }
}
