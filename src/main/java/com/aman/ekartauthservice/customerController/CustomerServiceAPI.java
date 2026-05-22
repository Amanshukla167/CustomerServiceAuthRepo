package com.aman.ekartauthservice.customerController;

import com.aman.ekartauthservice.customerDTO.AddressDTO;
import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.customerDTO.LoginDTO;
import com.aman.ekartauthservice.customerDTO.ResponseDTO;
import com.aman.ekartauthservice.customerServices.CustomerLoginAuthServices;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


     @GetMapping(value = "/userLogin/")
     public  ResponseEntity<ResponseDTO>Login( @Valid @RequestBody LoginDTO loginDTO) throws EkartExecption{

          ResponseDTO responseDTO = customerLoginAuthServices.Login(loginDTO);

          return  new ResponseEntity<ResponseDTO>( responseDTO , HttpStatus.ACCEPTED);
     }

     @PostMapping(value = "/userAddAddress/{email}")
     public ResponseEntity<ResponseDTO>addAddress(@PathVariable String email, @RequestBody @Valid AddressDTO addressDTO) throws  EkartExecption {

          ResponseDTO responseDTO = customerLoginAuthServices.addAddress(email , addressDTO);

          return  new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.CREATED);

     }

     @PutMapping(value = "/updateShippingAddress/{email}")
     public  ResponseEntity<ResponseDTO>updateShippingAddress(@PathVariable String email, @RequestBody @Valid AddressDTO addressDTO) throws EkartExecption{

          ResponseDTO responseDTO = customerLoginAuthServices.updateShippingAddress(email ,addressDTO);

          return  new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.ACCEPTED);

     }

     @DeleteMapping(value = "/DeleteCustomerAddress/{email}/addressId/{addressid}")
     public ResponseEntity<ResponseDTO>DeleteCustomerAddress(@PathVariable String email ,@PathVariable Integer addressid) throws EkartExecption{

          ResponseDTO responseDTO = customerLoginAuthServices.DeleteCustomerAddress(email , addressid);

          return  new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.OK);
     }

}
