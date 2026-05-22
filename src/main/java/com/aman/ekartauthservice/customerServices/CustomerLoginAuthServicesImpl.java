package com.aman.ekartauthservice.customerServices;

import com.aman.ekartauthservice.customerDTO.AddressDTO;
import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.customerDTO.ResponseDTO;
import com.aman.ekartauthservice.customerEntity.Address;
import com.aman.ekartauthservice.customerEntity.Customer;
import com.aman.ekartauthservice.customerRepo.AddressRepo;
import com.aman.ekartauthservice.customerRepo.CustomerRepo;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;
import com.aman.ekartauthservice.ekartSecurity.JwtService;
import com.aman.ekartauthservice.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerLoginAuthServicesImpl implements  CustomerLoginAuthServices{

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AddressRepo  addressRepo;

    @Override
    public ResponseDTO CreateAccount(CustomerDTO customerDTO) throws EkartExecption {

        Optional<Customer> custObj = customerRepo.findBycustomerEmailID(customerDTO.getCustomerEmailID());

         if(custObj.isPresent()){
             throw  new EkartExecption("this EmailId already Exist, please try with another ID");
         }

        Customer customer = new Customer();
        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setCustomerEmailID(customerDTO.getCustomerEmailID());
        customer.setCustomerPhoneNo(customerDTO.getCustomerPhoneNo());
        customer.setDOB(customerDTO.getDOB());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setRole(Role.valueOf(Role.USER.name()));

       AddressDTO addressDTO = customerDTO.getAddress();

       Address address = new Address();

       address.setHousNo(addressDTO.getHousNo());
       address.setCity(addressDTO.getCity());
       address.setDristric(addressDTO.getDristric());
       address.setPinCode(addressDTO.getPinCode());
       address.setState(addressDTO.getState());

       List<Address>  addresses = new ArrayList<Address>();

       addresses.add(address);

       customer.setAddress(addresses);

       customerRepo.save(customer);

       String token =  jwtService.genrateToken(customer.getCustomerEmailID() , customer.getRole().name());

       ResponseDTO responseDTO = new ResponseDTO();

       responseDTO.setCustoemrNamr(customer.getCustomerName());
       responseDTO.setRole(customer.getRole());
       responseDTO.setToken(token);
       responseDTO.setMessage("Your Account has been created successfully Your customer ID is "+ customer.getCustID() +" . Happy to have you..");

       return responseDTO;
    }

    @Override
    public ResponseDTO Login(String email, String Password) throws EkartExecption {

        Optional<Customer> custobj =  customerRepo.findBycustomerEmailID(email);

        Customer customer = custobj.orElseThrow(()-> new EkartExecption("the Customer is does not exist by this email Id, please try with diffrent one"));

         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, Password));

         String token = jwtService.genrateToken(customer.getCustomerEmailID() , customer.getRole().name());

         ResponseDTO responseDTO = new ResponseDTO();

         responseDTO.setCustoemrNamr(customer.getCustomerName());
         responseDTO.setRole(customer.getRole());
         responseDTO.setToken(token);
         responseDTO.setMessage("Welcome "  + customer.getCustomerName() + " you have successfully loged in");

        return responseDTO;
    }

    @Override
    public ResponseDTO addAddress(String email, AddressDTO addressDTO) throws EkartExecption {

        Optional<Customer> custobj =  customerRepo.findBycustomerEmailID(email);

//        ArrayList<Address>  adressList = new ArrayList<Address>();

        Customer customer = custobj.orElseThrow(()-> new EkartExecption("the Customer is does not exist by this email Id, please try with diffrent one"));

        List<Address> custAddressList = customer.getAddress();

        Address address = new Address();

        address.setHousNo(addressDTO.getHousNo());
        address.setCity(addressDTO.getCity());
        address.setDristric(addressDTO.getDristric());
        address.setPinCode(addressDTO.getPinCode());
        address.setState(addressDTO.getState());

        custAddressList.add(address);

        customer.setAddress(custAddressList);

        customerRepo.save(customer);

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCustoemrNamr(customer.getCustomerName());
        responseDTO.setRole(customer.getRole());

        responseDTO.setMessage("Hi.., "  + customer.getCustomerName() + " You address Successfully added..");

        return responseDTO;
    }

    @Override
    public ResponseDTO updateShippingAddress(String email, AddressDTO addressDTO) throws EkartExecption {

        Optional<Customer> custobj =  customerRepo.findBycustomerEmailID(email);
        Customer customer = custobj.orElseThrow(()-> new EkartExecption("the Customer is does not exist by this email Id, please try with diffrent one"));

         List<Address> addresses =  customer.getAddress();

         if( addresses == null ||addresses.isEmpty()){
             throw  new EkartExecption("There is no address to update");
         }

        for(Address address : addresses){
            if(address.getAddressID().equals(addressDTO.getAddressID())){

                address.setHousNo(addressDTO.getHousNo());
                address.setCity(addressDTO.getCity());
                address.setDristric(addressDTO.getDristric());
                address.setPinCode(addressDTO.getPinCode());
                address.setState(addressDTO.getState());

            }
        }


        customer.setAddress(addresses);
        customerRepo.save(customer);

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCustoemrNamr(customer.getCustomerName());
        responseDTO.setRole(customer.getRole());

        responseDTO.setMessage("Hi.., "  + customer.getCustomerName() + " Your address Successfully updated..");


        return responseDTO;
    }

    @Override
    public ResponseDTO DeleteCustomerAddress(String email , Integer addressid) throws EkartExecption {

        Optional<Customer> custobj =  customerRepo.findBycustomerEmailID(email);
        Customer customer = custobj.orElseThrow(()-> new EkartExecption("the Customer is does not exist by this email Id, please try with diffrent one"));

        List<Address> addresses =  customer.getAddress();

        if( addresses == null ||addresses.isEmpty()){
            throw  new EkartExecption("There is no address to delete");
        }

        for(Address address : addresses){
            if(address.getAddressID().equals(addressid)){
                addressRepo.delete(address);
                addresses.remove(address);
            }
        }
        customerRepo.save(customer);
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setCustoemrNamr(customer.getCustomerName());
        responseDTO.setRole(customer.getRole());

        responseDTO.setMessage("Hi.., "  + customer.getCustomerName() + " Your address Successfully deleted..");

        return responseDTO;
    }
}
