package com.aman.ekartauthservice.customerEntity;

import com.aman.ekartauthservice.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cust Id")
    private Integer custID;
    @Column(name = " Cutomer Name")
    private String customerName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "Date of Birth")
    private LocalDate DOB;
    @Column(name = "Customer Email ID")
    private  String customerEmailID;
    private String Password;
    @Column(name = "Customer phoneNo")
    private String customerPhoneNo;


    @JoinColumn(name ="cust ID")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address>  address;

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
