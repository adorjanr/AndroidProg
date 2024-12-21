package com.example.vizsgaminta2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private TextView total;
    private ArrayList<Expense> list;
    private ExpenseAdapter adapter;

    private void updateTotal() {
        float sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getAmount();
        }
        total.setText("Total: $" + String.valueOf(sum));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences.Editor editor = sp.edit();
        if (item.getItemId() == R.id.addItem) {
            list.add(new Expense("Lorem", 10, "Ipsum"));
            int i = list.size() - 1;
            editor.putInt("size", i + 1);
            editor.putString("desc_" + i, "Lorem");
            editor.putFloat("amount_" + i, 10);
            editor.putString("cat_" + i, "Ipsum");
            editor.apply();
            updateTotal();
            adapter.notifyDataSetChanged();
            return true;
        }
        if (item.getItemId() == R.id.deleteAll) {
            list.clear();
            editor.clear();
            editor.apply();
            updateTotal();
            adapter.notifyDataSetChanged();
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
        int size = sp.getInt("size", 0);
        list = new ArrayList<>();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String desc = sp.getString("desc_" + i, "");
                float amount = sp.getFloat("amount_" + i, 0);
                String cat = sp.getString("cat_" + i, "");
                list.add(new Expense(desc, amount, cat));
            }
        } else {
            list = Expense.getFirstItems();
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("size", list.size());
            for (int i = 0; i < list.size(); i++) {
                editor.putString("desc_" + i, list.get(i).getDescription());
                editor.putFloat("amount_" + i, list.get(i).getAmount());
                editor.putString("cat_" + i, list.get(i).getCategory());
            }
            editor.apply();
        }

        ListView lw = findViewById(R.id.lw);
        adapter = new ExpenseAdapter(this, list);
        lw.setAdapter(adapter);

        total = findViewById(R.id.twTotal);
        updateTotal();
    }
}