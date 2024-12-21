package com.example.vizsgaminta1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = getSharedPreferences("sp", MODE_PRIVATE);
        TextView counter = findViewById(R.id.twCounter);
        Button cancel = findViewById(R.id.btnCancel);
        Button ok = findViewById(R.id.btnOk);
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);

        int nr1 = sp.getInt("nr1", 0);
        int nr2 = sp.getInt("nr2", 0);
        int count = nr1 + nr2;
        counter.setText(String.valueOf(count));

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Kattintások száma: " + String.valueOf(count);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}