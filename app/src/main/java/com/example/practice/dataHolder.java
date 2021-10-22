package com.example.practice;

public class dataHolder {
    String name;
    String address;
    String phone;
    String status;

    public dataHolder() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String STATUS) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public dataHolder(String NAME, String ADDRESS, String PHONE,String STATUS) {

        this.name = NAME;
        this.address = ADDRESS;
        this.phone = PHONE;
        this.status = STATUS;
    }
}
