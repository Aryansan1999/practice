package com.example.practice;

import android.widget.Button;
import android.widget.EditText;
public class users {
    String fruitName,fruitUnit,unit;
    int fruitPrice;
    public users(String fruitName, String fruitUnit, String unit, long fruitPrice, EditText quantity) {
        this.fruitName = fruitName;
        this.fruitUnit = fruitUnit;
        this.unit = unit;
        this.fruitPrice = (int) fruitPrice;

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

    public long getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(int fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public users()
    {

    }

}

