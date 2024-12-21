package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("D", "MainActivity Statusz - onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("D", "MainActivity Statusz - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("D", "MainActivity Statusz - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("D", "MainActivity Statusz - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("D", "MainActivity Statusz - onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("D", "MainActivity Statusz - onDestroy()");
    }

    public void startActivityTwo(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
        startActivity(intent);
    }
}