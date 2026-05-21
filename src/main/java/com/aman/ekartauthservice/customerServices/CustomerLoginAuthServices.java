package com.aman.ekartauthservice.customerServices;


import com.aman.ekartauthservice.customerDTO.AddressDTO;
import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.customerDTO.ResponseDTO;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;

public interface CustomerLoginAuthServices {

      ResponseDTO CreateAccount(CustomerDTO customerDTO) throws EkartExecption;

      ResponseDTO Login(String email , String Password) throws  EkartExecption;

      ResponseDTO updateShippingAddress(String email, AddressDTO addressDTO) throws  EkartExecption;

      ResponseDTO DeleteCustomerAddress(String email , Integer addressid) throws  EkartExecption;

      ResponseDTO addAddress(String email , AddressDTO addressDTO) throws  EkartExecption;


}
