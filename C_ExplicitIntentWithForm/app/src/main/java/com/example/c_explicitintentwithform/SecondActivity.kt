package com.example.c_explicitintentwithform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*





class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val city = intent.getStringExtra("city")

        val personString = "$name with mail $email lives in $city"
        tvInfo.text = personString

//        Toast.makeText(applicationContext, name + email + city, Toast.LENGTH_LONG).show()

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}