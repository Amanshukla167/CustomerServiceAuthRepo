package com.aman.ekartauthservice.customerDTO;

public class AddressDTO {

    private Integer addressID;
    private String HousNo;
    private  Integer custID;
    private  String city;
    private String Dristric;
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

    public Integer getCustID() {
        return custID;
    }

    public void setCustID(Integer custID) {
        this.custID = custID;
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


}
