package com.aman.ekartauthservice.customerDTO;

import com.aman.ekartauthservice.enums.Role;

public class ResponseDTO {

    private String  CustoemrNamr;
    private Role role;
    private String message;
    private  String Token;

    public String getCustoemrNamr() {
        return CustoemrNamr;
    }

    public void setCustoemrNamr(String custoemrNamr) {
        CustoemrNamr = custoemrNamr;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
