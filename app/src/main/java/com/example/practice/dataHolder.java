package com.example.practice;

public class dataHolder {
    String ADDRESS,PHONE;





    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public dataHolder(String ADDRESS, String PHONE) {

        this.ADDRESS = ADDRESS;
        this.PHONE = PHONE;
    }
}
