package com.aman.ekartauthservice.customerServices;

import com.aman.ekartauthservice.customerDTO.CustomerDTO;
import com.aman.ekartauthservice.ekartCustomExecption.EkartExecption;

public interface AdminCustomerManageServices {

   CustomerDTO getCustomerDetail(String email) throws EkartExecption;



}
