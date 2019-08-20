package com.khevna.kpizza;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlaceOrderActivity extends AppCompatActivity {

    @BindView(R.id.sizeValueTextView)
    protected TextView sizeValueTextView;

    @BindView(R.id.sauceValueTextView)
    protected TextView sauceValueTextView;

    @BindView(R.id.toppingsValueTextView)
    protected TextView toppingsValueTextView;

    @BindView(R.id.cheeseValueTextView)
    protected TextView cheeseValueTextView;


    @BindView(R.id.SizeLayout)
    protected View sizeLayout;

    @BindView(R.id.SauceLayout)
    protected View sauceLayout;

    @BindView(R.id.toppingsLayout)
    protected View toppingsLayout;

    @BindView(R.id.cheeseLayout)
    protected View cheeseLayout;

    @BindView(R.id.reviewOrderButton)
    protected Button reviewOrderButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customize_main_screen);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeActionContentDescription(R.string.back);
        setTitle("Place Order");

    }


    @Override
    protected void onResume() {
        super.onResume();
        toppingsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(PlaceOrderActivity.this, ToppingsListActivity.class), 0);
            }
        });
        if (TextUtils.isEmpty(toppingsValueTextView.getText())) {
            toppingsLayout.setContentDescription("No Toppings selected");

        } else {
            toppingsLayout.setContentDescription("Toppings " + toppingsValueTextView.getText() + " is selected");
        }
        AccessibilityUtils.configureViewAccessibility(toppingsLayout)
                .setCustomAction(R.string.talkback_custom_action_add_or_change_toppings)
                .apply();
        sizeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(PlaceOrderActivity.this, SizeListActivity.class), 0);
            }
        });
        sizeLayout.setContentDescription("Pizza Size  " + sizeValueTextView.getText() + " is selected");
        AccessibilityUtils.configureViewAccessibility(sizeLayout)
                .setCustomAction(R.string.talkback_custom_action_change_size)
                .apply();
        sauceLayout.setContentDescription("Pizza Sauce  " + sauceValueTextView.getText() + " is selected");
        sauceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(PlaceOrderActivity.this, SauceListActivity.class), 0);
            }
        });



        cheeseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(PlaceOrderActivity.this, CheeseListActivity.class), 1);
            }
        });
        cheeseLayout.setContentDescription("Cheese " + toppingsValueTextView.getText() + " is selected");
        AccessibilityUtils.configureViewAccessibility(toppingsLayout)
                .setCustomAction(R.string.talkback_custom_action_add_or_change_toppings)
                .apply();

        AccessibilityUtils.configureViewAccessibility(sauceLayout)
                .setCustomAction(R.string.talkback_custom_action_change_sauce)
                .apply();
        reviewOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlaceOrderActivity.this, ReviewOrder.class);
                intent.putExtra("Size", sizeValueTextView.getText());
                intent.putExtra("Sauce", sauceValueTextView.getText());
                intent.putExtra("Toppings", toppingsValueTextView.getText());
                intent.putExtra("Cheese", cheeseValueTextView.getText());
                startActivity(intent);
            }
        });
        AccessibilityUtils.configureViewAccessibility(reviewOrderButton)
                .setCustomAction(R.string.talkback_custom_action_review_order)
                .apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data != null) {
                String message = data.getStringExtra("MESSAGE");
                toppingsValueTextView.setText(message);
            } else {
                toppingsValueTextView.setText("Pepperoni");
            }
        } else {
            if (data != null) {
                String message = data.getStringExtra("CHEESE");
                cheeseValueTextView.setText(message);
            } else {
                cheeseValueTextView.setText("Mozzarella");
            }
        }
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
