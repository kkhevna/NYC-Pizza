//package com.khevna.kpizza;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class ToppingsArrayAdapter extends ArrayAdapter<Toppings> {
//
//    ArrayList<Toppings> objects;
//    Listener listener;
//    Context context;
//
//    public ToppingsArrayAdapter(Context context, int resource, ArrayList<Toppings> objects) {
//        super(context, resource);
//        this.context = context;
//        this.objects = objects;
//    }
//
//    @Override public int getViewTypeCount() {
//        return super.getViewTypeCount();
//    }
//
//    @Override public int getCount() {
//        return objects.size();
//    }
//
//    @SuppressLint("InflateParams")
//    @Override
//    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
//
//        if (convertView == null){
//            Log.i("ToppingsArrayAdapter","ConvertView inflated");
//            convertView = LayoutInflater.from(context).inflate(R.layout.toppings_listview_item, null, false);
//        }
//
//        Log.i("ToppingsArrayAdapter","Setting of values");
//
//        final Toppings data = objects.get(position);
//        final ViewHolder viewHolder = new ViewHolder();
//
//        viewHolder.textView = convertView.findViewById(R.id.toppingName);
//        viewHolder.checkBox = convertView.findViewById(R.id.toppingCheck);
//
//        viewHolder.textView.setText(data.getToppings());
//
////        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                data.setChecked(isChecked);
////            }
////        });
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (data.isChecked) {
//                    data.setChecked(false);
//                    viewHolder.checkBox.setImageResource(R.drawable.baseline_uncheck);
//                    AccessibilityUtils.configureViewAccessibility(v)
//                            .setCustomAction(R.string.talkback_custom_action_select )
//                            .apply();
//                    v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_unselected, viewHolder.textView.getText()));
//                } else {
//                    data.setChecked(true);
//                    viewHolder.checkBox.setImageResource(R.drawable.ic_baseline_check_24px);
//                    AccessibilityUtils.configureViewAccessibility(v)
//                            .setCustomAction(R.string.talkback_custom_action_unselect)
//                            .apply();
//                    v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_selected, viewHolder.textView.getText()));
//
//                }
//            }
//        });
//
//        AccessibilityUtils.configureViewAccessibility(convertView)
//                .setCustomAction(data.isChecked ? R.string.talkback_custom_action_unselect : R.string.talkback_custom_action_select)
//                .apply();
//
//        return convertView;
//    }
//
//    public void setListener(Listener listener) {
//        this.listener = listener;
//    }
//
//    private class ViewHolder {
//
//        TextView textView;
//        ImageView checkBox;
//    }
//
//    public ArrayList<Toppings> getObjects() {
//        return objects;
//    }
//
//    public void setObjects(ArrayList<Toppings> objects) {
//        this.objects = objects;
//        notifyDataSetChanged();
//    }
//
//    @Override public long getItemId(int position) {
//        return super.getItemId(position);
//    }
//
//    public interface Listener {
//        void onCheckedChanged(int position);
//    }
//}
