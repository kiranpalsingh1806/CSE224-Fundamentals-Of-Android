package com.example.c_explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val id:Int = 10
    val msg:String = "Kotlin message here"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnC = findViewById<Button>(R.id.btnClickHere)

        btnC.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("id_value", id)
            intent.putExtra("msg_value", msg)
            startActivity(intent)
        }

    }
}