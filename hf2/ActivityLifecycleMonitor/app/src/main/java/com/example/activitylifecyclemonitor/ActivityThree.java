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

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_three);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("D", "ActivityThree Statusz - onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("D", "ActivityThree Statusz - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("D", "ActivityThree Statusz - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("D", "ActivityThree Statusz - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("D", "ActivityThee Statusz - onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("D", "ActivityThree Statusz - onDestroy()");
    }

    public void startMainActivity(View v) {
        Intent intent = new Intent(ActivityThree.this, MainActivity.class);
        startActivity(intent);
    }
}