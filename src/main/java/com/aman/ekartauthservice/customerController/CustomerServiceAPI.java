package com.aman.ekartauthservice.customerController;

import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.customerDTO.ResponseDTO;
import com.aman.ekartauthservice.customerServices.CustomerLoginAuthServices;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class CustomerServiceAPI {

     @Autowired
     private CustomerLoginAuthServices customerLoginAuthServices;



     @PostMapping(value = "/createUserAccount")
     public ResponseEntity<ResponseDTO>createAccount( @Valid @RequestBody CustomerDTO customerDTO) throws EkartExecption {

          ResponseDTO responseDTO = customerLoginAuthServices.CreateAccount(customerDTO);

         return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.CREATED);
     }

}
