package com.example.vizsgaminta1;

import static com.example.vizsgaminta1.R.id.resetOption;
import static com.example.vizsgaminta1.R.id.saveOption;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private EditText et1;
    private EditText et2;

    public void addOne(View view) {
        int nr = Integer.parseInt(et2.getText().toString()) + 1;
        et2.setText(String.valueOf(nr));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences.Editor editor = sp.edit();
        if (item.getItemId() == R.id.saveOption) {
            editor.putInt("nr1", Integer.parseInt(et1.getText().toString()));
            editor.putInt("nr2", Integer.parseInt(et2.getText().toString()));
            editor.commit();
            return true;
        }
        if (item.getItemId() == R.id.resetOption) {
            editor = sp.edit();
            editor.putInt("nr1", 0);
            editor.putInt("nr2", 0);
            editor.commit();
            et1.setText("0");
            et2.setText("0");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

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

        sp = getSharedPreferences("sp", MODE_PRIVATE);
        int nr1 = sp.getInt("nr1", 0);
        int nr2 = sp.getInt("nr2", 0);
        et1 = findViewById(R.id.editTextText);
        et2 = findViewById(R.id.editTextText2);
        et1.setText(String.valueOf(nr1));
        et2.setText(String.valueOf(nr2));
        Button btn1 = findViewById(R.id.button);
        Button btnSecond = findViewById(R.id.btnSecond);
        Button btnThird = findViewById(R.id.btnThird);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nr = Integer.parseInt(et1.getText().toString()) + 1;
                et1.setText(String.valueOf(nr));
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("nr1", Integer.parseInt(et1.getText().toString()));
                editor.putInt("nr2", Integer.parseInt(et2.getText().toString()));
                editor.commit();
                startActivity(intent);
            }
        });

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}