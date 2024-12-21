package com.example.activitylifecyclemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("D", "ActivityTwo Statusz - onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("D", "ActivityTwo Statusz - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("D", "ActivityTwo Statusz - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("D", "ActivityTwo Statusz - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("D", "ActivityTwo Statusz - onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("D", "ActivityTwo Statusz - onDestroy()");
    }

    public void startActivityThree(View v) {
        Intent intent = new Intent(ActivityTwo.this, ActivityThree.class);
        startActivity(intent);
    }
}