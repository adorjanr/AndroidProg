package com.example.tablelayout;

import androidx.annotation.NonNull;

public class Product {
    public String productCode;
    public String productName;
    public float productPrice;

    public Product(String productCode, String productName, float productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return this.productCode + " - " + this.productName + ", " + String.valueOf(this.productPrice);
    }
}
