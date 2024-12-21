package com.example.vizsgaminta2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ExpenseAdapter extends ArrayAdapter<Expense> {
    private Activity context;
    private ArrayList<Expense> list;

    public ExpenseAdapter(Activity context, ArrayList<Expense> list) {
        super(context, R.layout.list_item);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_item, null);

        TextView desc = view.findViewById(R.id.twDescription);
        TextView amount = view.findViewById(R.id.twAmount);
        TextView cat = view.findViewById(R.id.twCategory);

        desc.setText(list.get(position).getDescription());
        String amountMsg = "$" + String.valueOf(list.get(position).getAmount());
        amount.setText(amountMsg);
        cat.setText(list.get(position).getCategory());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense = list.get(position);
                Toast.makeText(context, expense.getCategory(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ExpenseDetailsActivity.class);
                intent.putExtra("expense", expense);
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
