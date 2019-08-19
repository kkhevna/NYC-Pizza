package com.khevna.kpizza

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

class ToppingsArrayAdapter(internal var context: Context, resource: Int, internal var objects: ArrayList<Toppings>) : ArrayAdapter<Toppings>(context, resource) {

    override fun getViewTypeCount(): Int {
        return super.getViewTypeCount()
    }

    override fun getCount(): Int {
        return objects.size
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        if (convertView == null) {
            Log.i("ToppingsArrayAdapter", "ConvertView inflated")
            convertView = LayoutInflater.from(context).inflate(R.layout.toppings_listview_item, null, false)
        }

        Log.i("ToppingsArrayAdapter", "Setting of values")

        val data = objects[position]
        val viewHolder = ViewHolder()

        viewHolder.textView = convertView!!.findViewById(R.id.toppingName)
        viewHolder.checkBox = convertView.findViewById(R.id.toppingCheck)

        viewHolder.textView!!.text = data.getToppings()


        convertView.setOnClickListener { v ->
            if (data.isChecked) {
                data.setChecked(false)
                viewHolder.checkBox?.setImageResource(R.drawable.baseline_uncheck)
                v.configureViewAccessibility()
                        .setCustomAction(R.string.talkback_custom_action_select)
                        .apply()
                v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_unselected, viewHolder.textView?.text))
            } else {
                data.setChecked(true)
                viewHolder.checkBox?.setImageResource(R.drawable.ic_baseline_check_24px)
                v.configureViewAccessibility()
                        .setCustomAction(R.string.talkback_custom_action_unselect)
                        .apply()
                v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_selected, viewHolder.textView?.text))

            }
        }

        convertView.configureViewAccessibility()
                .setCustomAction(if (data.isChecked) R.string.talkback_custom_action_unselect else R.string.talkback_custom_action_select)
                .apply()

        return convertView
    }


    private inner class ViewHolder {

        internal var textView: TextView? = null
        internal var checkBox: ImageView? = null
    }

    fun getObjects(): ArrayList<Toppings> {
        return objects
    }

    fun setObjects(objects: ArrayList<Toppings>) {
        this.objects = objects
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    interface Listener {
        fun onCheckedChanged(position: Int)
    }
}
