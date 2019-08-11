package com.khevna.kpizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewOrder extends AppCompatActivity {

    @BindView(R.id.sizeValueTextView)
    protected TextView sizeValueTextView;

    @BindView(R.id.sauceValueTextView)
    protected TextView sauceValueTextView;

    @BindView(R.id.toppingsValueTextView)
    protected TextView toppingsValueTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_order);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Review Order");

        Intent i = getIntent();
        sizeValueTextView.setText(i.getStringExtra("Size"));
        sauceValueTextView.setText(i.getStringExtra("Sauce"));
        toppingsValueTextView.setText(i.getStringExtra("Toppings"));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                finish();
                break;

        }

        return true;
    }
}
