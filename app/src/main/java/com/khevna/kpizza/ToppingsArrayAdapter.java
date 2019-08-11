package com.khevna.kpizza;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ToppingsArrayAdapter extends ArrayAdapter<Toppings> {

    ArrayList<Toppings> objects;
    Listener listener;
    Context context;

    public ToppingsArrayAdapter(Context context, int resource, ArrayList<Toppings> objects) {
        super(context, resource);
        this.context = context;
        this.objects = objects;
    }

    @Override public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override public int getCount() {
        return objects.size();
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            Log.i("ExampleAdapter","ConvertView inflated");
            convertView = LayoutInflater.from(context).inflate(R.layout.toppings_listview_item, null, false);
        }

        Log.i("ExampleAdapter","Setting of values");

        final Toppings data = objects.get(position);
        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.textView = (TextView) convertView.findViewById(R.id.toppingName);
        viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.toppingCheckBox);

        viewHolder.textView.setText(data.getToppings());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.setChecked(isChecked);
            }
        });

        return convertView;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private class ViewHolder {

        TextView textView;
        CheckBox checkBox;
    }

    public ArrayList<Toppings> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Toppings> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    @Override public long getItemId(int position) {
        return super.getItemId(position);
    }

    public interface Listener {
        void onCheckedChanged(int position);
    }
}
