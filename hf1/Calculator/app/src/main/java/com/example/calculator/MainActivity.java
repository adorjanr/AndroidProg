package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        EditText number1 = findViewById(R.id.number1);
        EditText number2 = findViewById(R.id.number2);
        TextView result = findViewById(R.id.result);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer nr1 = Integer.parseInt(number1.getText().toString());
                    Integer nr2 = Integer.parseInt(number2.getText().toString());
                    int intResult = nr1 + nr2;
                    result.setText(String.valueOf(intResult));
                } catch (NumberFormatException e) {
                    result.setText("Values are not Integers");
                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer nr1 = Integer.parseInt(number1.getText().toString());
                    Integer nr2 = Integer.parseInt(number2.getText().toString());
                    int intResult = nr1 - nr2;
                    result.setText(String.valueOf(intResult));
                } catch (NumberFormatException e) {
                    result.setText("Values are not Integers");
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer nr1 = Integer.parseInt(number1.getText().toString());
                    Integer nr2 = Integer.parseInt(number2.getText().toString());
                    int intResult = nr1 * nr2;
                    result.setText(String.valueOf(intResult));
                } catch (NumberFormatException e) {
                    result.setText("Values are not Integers");
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Integer nr1 = Integer.parseInt(number1.getText().toString());
                    Integer nr2 = Integer.parseInt(number2.getText().toString());
                    if (nr2 != 0) {
                        float floatResult = (float) nr1 / nr2;
                        result.setText(String.valueOf(floatResult));
                    }
                    else result.setText("Zero division error");
                } catch (NumberFormatException e) {
                    result.setText("Values are not Integers");
                }
            }
        });
    }
}