package com.khevna.kpizza

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView


import java.util.ArrayList

class CheeseArrayAdapter(internal var context: Context, resource: Int, internal var objects: ArrayList<Cheese>) : ArrayAdapter<Cheese>(context, resource) {

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
            Log.i("CheeseArrayAdapter", "ConvertView inflated")
            convertView = LayoutInflater.from(context).inflate(R.layout.cheese_listview_item, null, false)
        }

        Log.i("CheeseArrayAdapter", "Setting of values")

        val data = objects[position]
        val viewHolder = ViewHolder()

        viewHolder.textView = convertView!!.findViewById(R.id.cheeseName)
        viewHolder.checkBox = convertView.findViewById(R.id.cheeseCheck)
        viewHolder.lessCheese = convertView.findViewById(R.id.lessCheese)
        viewHolder.moreCheese = convertView.findViewById(R.id.moreCheese)
        viewHolder.seekBar = convertView.findViewById(R.id.cheeseSeekBar)

        viewHolder.textView!!.text = data.cheeseType


        convertView.run {

            viewHolder.textView = convertView!!.findViewById(R.id.cheeseName)
            viewHolder.checkBox = convertView.findViewById(R.id.cheeseCheck)
            viewHolder.lessCheese = convertView.findViewById(R.id.lessCheese)
            viewHolder.moreCheese = convertView.findViewById(R.id.moreCheese)
            viewHolder.seekBar = convertView.findViewById(R.id.cheeseSeekBar)

            viewHolder.textView!!.text = data.cheeseType


            convertView.setOnClickListener {v ->

                            if (data.isChecked) {
                                data.isChecked = false
                                viewHolder.checkBox?.setImageResource(R.drawable.baseline_uncheck)
                                v.configureViewAccessibility()
                                        .setCustomAction(R.string.talkback_custom_action_select)
                                        .apply()
                                v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_unselected, viewHolder.textView?.text))
                            } else {
                                data.isChecked = true
                                viewHolder.checkBox?.setImageResource(R.drawable.ic_baseline_check_24px)
                                v.configureViewAccessibility()
                                        .setCustomAction(R.string.talkback_custom_action_unselect)
                                        .apply()
                                v.announceForAccessibility(context.getString(R.string.talkback_custom_topping_selected, viewHolder.textView?.text))
                                viewHolder.lessCheese?.importantForAccessibility = 1
                                viewHolder.moreCheese?.importantForAccessibility = 1

                            }
            }
        }

        convertView.configureViewAccessibility()
                .setCustomAction(if (data.isChecked) R.string.talkback_custom_action_unselect else R.string.talkback_custom_action_select)
                .apply()



        viewHolder.lessCheese?.contentDescription = "Reduce cheese button"
        viewHolder.moreCheese?.contentDescription = "Add more cheese button"

        viewHolder.lessCheese?.configureViewAccessibility()
                ?.setCustomAction("reduce cheese ")
                ?.apply()

        viewHolder.moreCheese?.configureViewAccessibility()
                ?.setCustomAction("add more cheese ")
                ?.apply()

        viewHolder.lessCheese?.setOnClickListener { v ->
            if (viewHolder.seekBar?.progress != 0) {
                viewHolder.seekBar?.progress = viewHolder.seekBar?.progress!!.minus(1)
            }
        }

        viewHolder.moreCheese?.setOnClickListener { v ->
            if (viewHolder.seekBar?.progress != 3) {
                viewHolder.seekBar?.progress = viewHolder.seekBar?.progress!!.plus(1)
            }
        }

        return convertView
    }


    private inner class ViewHolder {

        internal var textView: TextView? = null
        internal var checkBox: ImageView? = null
        internal var lessCheese: TextView? = null
        internal var moreCheese: TextView? = null
        internal var seekBar: SeekBar? = null
    }

    fun getObjects(): ArrayList<Cheese> {
        return objects
    }

    fun setObjects(objects: ArrayList<Cheese>) {
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
