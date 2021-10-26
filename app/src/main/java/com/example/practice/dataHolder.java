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


    public String getStatus() {
        return status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public dataHolder(String NAME, String ADDRESS, String PHONE, String STATUS) {

        this.name = NAME;
        this.address = ADDRESS;
        this.phone = PHONE;
        this.status = STATUS;
    }
}
