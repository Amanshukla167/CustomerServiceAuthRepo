package com.aman.ekartauthservice.customerController;

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
@RequestMapping(value = "/admin")
public class AdminServiceAPI {


    @Autowired
    private CustomerLoginAuthServices customerLoginAuthServices;


    @GetMapping(value = "/Login")
    public  ResponseEntity<ResponseDTO>Login( @Valid @RequestBody LoginDTO loginDTO) throws EkartExecption {

        ResponseDTO responseDTO = customerLoginAuthServices.Login(loginDTO);

        return  new ResponseEntity<ResponseDTO>( responseDTO , HttpStatus.ACCEPTED);
    }
}
