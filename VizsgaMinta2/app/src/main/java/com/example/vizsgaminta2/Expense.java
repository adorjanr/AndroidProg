package com.example.vizsgaminta2;

import java.io.Serializable;
import java.util.ArrayList;

public class Expense implements Serializable {
    private  String description;
    private float amount;
    private String category;

    public Expense(String description, float amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Expense> getFirstItems() {
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("Groceries", 50, "Food"));
        expenses.add(new Expense("Utilities", 100, "Bills"));
        expenses.add(new Expense("Transportation", 30, "Transportation"));
        expenses.add(new Expense("Entertainment", 20, "Entertainment"));
        expenses.add(new Expense("Clothing", 40, "Shopping"));
        return expenses;
    }
}
