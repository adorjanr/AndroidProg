package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Integer[] imageArray = {
            R.drawable.eu,
            R.drawable.usa,
            R.drawable.uk,
            R.drawable.australia,
            R.drawable.canada,
            R.drawable.switzerland,
            R.drawable.denmark,
            R.drawable.hungary
    };
    String[] currencyShortArray = {
            "EUR",
            "USD",
            "GBP",
            "AUD",
            "CAD",
            "CHF",
            "DKK",
            "HUF"
    };
    String[] currencyArray = {
            "Euro",
            "Amerikai dollar",
            "Angol font",
            "Ausztral dollar",
            "Kanadai dollar",
            "Svajci frank",
            "Dan korona",
            "Magyar forint"
    };
    String[] purchasePrice = {
            "4,4100",
            "3,9750",
            "6,1250",
            "2,9600",
            "3,0950",
            "4,2300",
            "0,5850",
            "0,0136"
    };
    String[] sellPrice = {
            "4,5500",
            "4,1450",
            "6,3550",
            "3,0600",
            "3,2650",
            "4,3300",
            "0,6150",
            "0,0146"
    };
    ListView listView;

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

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, imageArray, currencyShortArray, currencyArray, purchasePrice, sellPrice);
        listView = findViewById(R.id.listviewid);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = currencyShortArray[position] + ": " + purchasePrice[position];
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}