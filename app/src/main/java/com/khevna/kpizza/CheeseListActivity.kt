package com.khevna.kpizza

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import kotlinx.android.synthetic.main.cheese_list.*


import java.util.ArrayList

import butterknife.ButterKnife

class CheeseListActivity : AppCompatActivity() {


    lateinit var objects: ArrayList<Cheese>
    lateinit var simpleList: ListView

    private val checkedItems: String
        get() {
            val sb = StringBuilder()
            if (objects[0].isChecked) {
                sb.append(objects[0].cheeseType)
            }
            for (i in 1..2) {
                if (objects[i].isChecked) {
                    if (sb.length > 0) {
                        sb.append(", ")
                    }
                    sb.append(objects[i].cheeseType)
                }
            }
            return sb.toString()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cheese_list)
        simpleList = findViewById(R.id.cheeseListView)
        ButterKnife.bind(this)
        objects = ArrayList()

        objects.add(Cheese("Provolone"))
        objects.add(Cheese("Parmesan"))
        objects.add(Cheese("Mozzarella"))
        val arrayAdapter = CheeseArrayAdapter(this, R.layout.cheese_listview_item, objects)
        simpleList.adapter = arrayAdapter
        title = "Select Pizza Cheese"
        arrayAdapter.notifyDataSetChanged()

    }


    override fun onResume() {
        super.onResume()
        doneButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("CHEESE", checkedItems)
            setResult(1, intent)
            finish()
        }
    }
}
