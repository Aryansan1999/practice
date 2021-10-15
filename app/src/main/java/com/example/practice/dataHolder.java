package com.example.practice;

public class dataHolder {
    String NAME;
    String ADDRESS;
    String PHONE;
    String STATUS;


    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String STATUS) {
        this.PHONE = PHONE;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public dataHolder(String NAME, String ADDRESS, String PHONE,String STATUS) {

        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.PHONE = PHONE;
        this.STATUS = STATUS;
    }
}
