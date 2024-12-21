package com.example.optionsandcontextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String[] listAux = {"egy", "ketto", "harom", "negy", "ot", "hat", "het"};
    private ArrayList<String> list = new ArrayList<String>(Arrays.asList(listAux));
    private ArrayAdapter adapter;

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

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ListView lw = findViewById(R.id.listview);
        lw.setAdapter(adapter);
        registerForContextMenu(lw);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
    // nem tudom, hogy kéne átszínezni
        if (item.getItemId() == R.id.piros) {
            Toast.makeText(MainActivity.this, "piros", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.zold) {
            Toast.makeText(MainActivity.this, "zold", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.kek) {
            Toast.makeText(MainActivity.this, "kek", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sort) {
            list.sort(null);
            adapter.notifyDataSetChanged();
            return true;
        }
        if (item.getItemId() == R.id.delete) {
            list.clear();
            adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}