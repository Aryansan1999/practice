package com.example.practice;

import android.widget.EditText;
public class users {
    String fruitName,fruitUnit,unit,fruitPrice;

    public users(String fruitName, String fruitUnit, String unit, String fruitPrice, EditText quantity) {
        this.fruitName = fruitName;
        this.fruitUnit = fruitUnit;
        this.unit = unit;
        this.fruitPrice =fruitPrice;

    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitUnit() {
        return fruitUnit;
    }

    public void setFruitUnit(String fruitUnit) {
        this.fruitUnit = fruitUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public users()
    {

    }

}

