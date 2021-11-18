package com.example.c_explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnB = findViewById<Button>(R.id.btnBack)


        val bundle:Bundle? = intent.extras
        val id = bundle?.get("id_value")
        val msg = bundle?.get("msg_value")

        Toast.makeText(applicationContext, id.toString() + " " + msg, Toast.LENGTH_LONG).show()

        btnB.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}