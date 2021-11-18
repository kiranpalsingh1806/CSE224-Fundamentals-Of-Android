package com.example.c_incrementdecrementcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.editTextNumber)
        var plus = findViewById<Button>(R.id.plus)
        var minus = findViewById<Button>(R.id.minus)

        plus.setOnClickListener {
            var input = editText.text.toString().toInt()
            input += 1
            var sol:String = input.toString()
            editText.setText(sol)
        }

        minus.setOnClickListener {
            var input = editText.text.toString().toInt()
            input -= 1
            var sol:String = input.toString()
            editText.setText(sol)
        }
    }
}