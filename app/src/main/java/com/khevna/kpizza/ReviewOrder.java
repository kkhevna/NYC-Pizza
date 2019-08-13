package com.khevna.kpizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewOrder extends AppCompatActivity {

    @BindView(R.id.SizeLayout)
    protected View sizeLayout;

    @BindView(R.id.SauceLayout)
    protected View sauceLayout;

    @BindView(R.id.toppingsLayout)
    protected View toppingsLayout;

    @BindView(R.id.sizeValueTextView)
    protected TextView sizeValueTextView;

    @BindView(R.id.sauceValueTextView)
    protected TextView sauceValueTextView;

    @BindView(R.id.toppingsValueTextView)
    protected TextView toppingsValueTextView;

    @BindView(R.id.orderButton)
    protected Button orderButton;

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
        toppingsLayout.setContentDescription("Toppings " + toppingsValueTextView.getText() + "selected");
        toppingsLayout.setClickable(false);

        sizeLayout.setContentDescription("Pizza Size  " + sizeValueTextView.getText() + "selected");
        sizeLayout.setClickable(false);


        sauceLayout.setContentDescription("Pizza Sauce  " + sauceValueTextView.getText() + "selected");
        sauceLayout.setClickable(false);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        AccessibilityUtils.configureViewAccessibility(orderButton)
                .setCustomAction(R.string.talkback_custom_action_order)
                .apply();
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
