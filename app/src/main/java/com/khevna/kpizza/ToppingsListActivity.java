package com.khevna.kpizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToppingsListActivity extends AppCompatActivity {

    @BindView(R.id.doneButton)
    protected Button doneButton;

    ArrayList<Toppings> objects;
    ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toppings_list);
        simpleList = findViewById(R.id.toppingsListView);
        ButterKnife.bind(this);
        objects = new ArrayList<>();

        objects.add(new Toppings("Pepperoni"));
        objects.add(new Toppings("Peppers"));
        objects.add(new Toppings("Tomatoes"));
        ToppingsArrayAdapter arrayAdapter = new ToppingsArrayAdapter(this, R.layout.toppings_listview_item, objects);
        simpleList.setAdapter(arrayAdapter);
        setTitle("Select Pizza Toppings");
        arrayAdapter.notifyDataSetChanged();

    }


    @Override
    protected void onResume() {
        super.onResume();
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", getCheckedItems());
                setResult(0, intent);
                finish();
            }
        });
    }

    private String getCheckedItems() {
        StringBuilder sb = new StringBuilder();
        if (objects.get(0).isChecked()) {
            sb.append(objects.get(0).getToppings());
        }
        for (int i = 1; i < 3; i++) {
            if (objects.get(i).isChecked()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(objects.get(i).getToppings());
            }
        }
        return sb.toString();
    }
}
