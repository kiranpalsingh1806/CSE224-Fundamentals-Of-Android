package com.example.c_dynamicviewexample

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.marginBottom
import android.view.ViewGroup.MarginLayoutParams
import android.R.attr.right

import android.R.attr.left
import android.view.ViewGroup


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        var btn1 = findViewById<Button>(R.id.btn1)
        var btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener {
            var btn2:Button = Button(this)
            btn2.text  = "New Button"

            btn2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            var pf:TextView = TextView(this)
            pf.text = "New Button Created"
            pf.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            btn2.setOnClickListener {
                Toast.makeText(this, "New Dynamic Button", Toast.LENGTH_LONG).show()
            }

            linearLayout.addView(btn2)
            linearLayout.addView(pf)
        }

        btn3.setOnClickListener {
            var image1:ImageView = ImageView(this)
            image1.setImageResource(R.mipmap.ic_launcher)

            image1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            linearLayout.addView(image1)
        }

    }
}