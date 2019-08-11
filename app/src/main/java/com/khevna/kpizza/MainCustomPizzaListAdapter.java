package com.khevna.kpizza;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MainCustomPizzaListAdapter extends ArrayAdapter {

    private final Activity context;

    //to store the list of countries
    private final String[] itemNameArray;

    //to store the list of countries
    private final String[] itemOptionsArray;

    public MainCustomPizzaListAdapter(Activity context, String[] itemNameArray, String[] itemOptionsArray) {
        super(context, R.layout.customize_main_screen_list_item, itemNameArray);

        this.context = context;
        this.itemNameArray = itemNameArray;
        this.itemOptionsArray = itemOptionsArray;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.customize_main_screen_list_item, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.sizeTextView);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.sizeValueTextView);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(itemNameArray[position]);
        infoTextField.setText(itemOptionsArray[position]);

        return rowView;

    };
}
