package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText code = findViewById(R.id.etCode);
        EditText name = findViewById(R.id.etName);
        EditText price = findViewById(R.id.etPrice);
        Button add = findViewById(R.id.btnAdd);
        Button cancel = findViewById(R.id.btnCancel);
        Button showlist = findViewById(R.id.btnShowList);
        TextView list = findViewById(R.id.twList);

        ArrayList<Product> products = new ArrayList<>();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (code.getText().toString().isBlank()) throw new Exception("Product has no code");
                    if (name.getText().toString().isBlank()) throw new Exception("Product has no name");
                    float floatPrice = Float.parseFloat(price.getText().toString());
                    Product p = new Product(code.getText().toString(), name.getText().toString(), floatPrice);
                    products.add(p);
                    code.setText("");
                    name.setText("");
                    price.setText("");
                    Toast.makeText(MainActivity.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Price should be a number", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.setText("");
                name.setText("");
                price.setText("");
            }
        });
        
        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.setText("");
                for (Product product : products) {
                    list.setText(list.getText() + "\n" + product.toString());
                }
            }
        });
    }
}