package com.example.vizsgaminta2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExpenseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expense_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView desc = findViewById(R.id.detailDesc);
        TextView amount = findViewById(R.id.detailAmount);
        TextView cat = findViewById(R.id.detailCat);
        Expense expense = (Expense) getIntent().getExtras().getSerializable("expense");
        desc.setText(expense.getDescription());
        amount.setText("$" + String.valueOf(expense.getAmount()));
        cat.setText(expense.getCategory());
    }
}