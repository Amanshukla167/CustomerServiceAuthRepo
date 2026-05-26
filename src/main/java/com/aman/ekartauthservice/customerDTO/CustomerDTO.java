package com.aman.ekartauthservice.customerDTO;

import com.aman.ekartauthservice.customerEntity.Address;
import com.aman.ekartauthservice.enums.Role;

import java.time.LocalDate;
import java.util.List;

public class CustomerDTO {

    private Integer custID;
    private String customerName;
    private LocalDate DOB;
    private  String customerEmailID;
    private String Password;
    private String customerPhoneNo;

    private List<AddressDTO> address;

    private Role role;

    public Integer getCustID() {
        return custID;
    }

    public void setCustID(Integer custID) {
        this.custID = custID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getCustomerEmailID() {
        return customerEmailID;
    }

    public void setCustomerEmailID(String customerEmailID) {
        this.customerEmailID = customerEmailID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
