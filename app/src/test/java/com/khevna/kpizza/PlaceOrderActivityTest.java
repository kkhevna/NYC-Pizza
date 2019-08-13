package com.khevna.kpizza;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class PlaceOrderActivityTest {

    PlaceOrderActivity placeOrderActivity;

    @Before
    public void setup() {
        placeOrderActivity = Robolectric.setupActivity(PlaceOrderActivity.class);
    }

    @Test
    public void testContentDescription() {
        assertEquals(placeOrderActivity.reviewOrderButton.getText(), placeOrderActivity.reviewOrderButton.getContentDescription());
    }

}