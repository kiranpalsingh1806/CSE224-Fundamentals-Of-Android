package com.example.list_view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.listView)

        var b = arrayOf("Blue", "Gray", "Green", "Cyan")
        var ab = ArrayAdapter(this, android.R.layout.simple_list_item_1, b)
        lv.adapter = ab;

        lv.setOnItemClickListener { adapterView, view, position, id ->
            val str = adapterView.getItemAtPosition(position) as String
            Toast.makeText(this, "Background Color is changed to $str", Toast.LENGTH_LONG).show()

            if(str == "Blue") {
                lv.setBackgroundColor(Color.BLUE);
            } else if(str == "Gray") {
                lv.setBackgroundColor(Color.GRAY);
            } else if(str == "Green") {
                lv.setBackgroundColor(Color.GREEN);
            } else if(str == "Cyan") {
                lv.setBackgroundColor(Color.CYAN);
            }
        }
    }
}

