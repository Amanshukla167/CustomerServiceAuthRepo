package com.aman.ekartauthservice.customerEntity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name =  "CustomerAddress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address ID")
    private Integer addressID;

    @Column(name = "House No")
    private String HousNo;

    @Column(name = "City")
    private  String city;

    private String Dristric;

    @Column(name = "Pin Code")
    private String pinCode;

    private  String State ;


    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getHousNo() {
        return HousNo;
    }

    public void setHousNo(String housNo) {
        HousNo = housNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDristric() {
        return Dristric;
    }

    public void setDristric(String dristric) {
        Dristric = dristric;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  false;
        if(obj == null || this.getClass() != obj.getClass()) return  false;

        Address address = (Address) obj;

        return Objects.equals(this.addressID , address.addressID);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.addressID);
    }
}
