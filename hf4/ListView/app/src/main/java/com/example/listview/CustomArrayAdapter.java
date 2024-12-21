package com.example.listview;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomArrayAdapter extends ArrayAdapter {
    private Activity context;
    private Integer[] imageArray;
    private String[] currencyShortArray;
    private String[] currencyArray;
    private String[] purchasePriceArray;
    private String[] sellPriceArray;

    public CustomArrayAdapter(Activity context, Integer[] imageArray, String[] currencyShortArray, String[] currencyArray, String[] purchasePriceArray, String[] sellPriceArray) {
        super(context, R.layout.list_item);
        this.context = context;
        this.imageArray = imageArray;
        this.currencyShortArray = currencyShortArray;
        this.currencyArray = currencyArray;
        this.purchasePriceArray = purchasePriceArray;
        this.sellPriceArray = sellPriceArray;
        Log.d("D", "Statusz - constructor");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("D", "Statusz - getview");
        LayoutInflater inflater = context.getLayoutInflater();
        View listItem = inflater.inflate(R.layout.list_item, null);

        ImageView flag = listItem.findViewById(R.id.flag);
        TextView currencyShort = listItem.findViewById(R.id.currencyShort);
        TextView currency = listItem.findViewById(R.id.currency);
        TextView purchasePrice = listItem.findViewById(R.id.purchasePrice);
        TextView sellPrice = listItem.findViewById(R.id.sellPrice);

        flag.setImageResource(imageArray[position]);
        currencyShort.setText(currencyShortArray[position]);
        currency.setText(currencyArray[position]);
        purchasePrice.setText(purchasePriceArray[position]);
        sellPrice.setText(sellPriceArray[position]);

        return listItem;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }
}
