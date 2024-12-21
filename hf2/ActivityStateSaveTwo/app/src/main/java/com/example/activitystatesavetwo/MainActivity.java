package com.example.activitystatesavetwo;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

        EditText et = findViewById(R.id.editTextText);
        CheckBox cb = findViewById(R.id.checkBox);

        if (savedInstanceState != null) {
            if (savedInstanceState.getString("myEt") != null) {
                et.setText(savedInstanceState.getString("myEt"));
            }
            cb. setChecked(savedInstanceState.getBoolean("myCb"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        EditText et = findViewById(R.id.editTextText);
        CheckBox cb = findViewById(R.id.checkBox);
        outState.putString("myEt", et.getText().toString());
        outState.putBoolean("myCb", cb.isChecked());
    }
}