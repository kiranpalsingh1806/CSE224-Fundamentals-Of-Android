package com.example.c_explicitintentwithform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister.setOnClickListener {
            Toast.makeText(this, etName.text, Toast.LENGTH_SHORT).show()
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val city = etCity.text.toString()

            Intent(this, SecondActivity::class.java).also {
                it.putExtra("name", name)
                it.putExtra("email", email)
                it.putExtra("city", city)
                startActivity(it)
            }

        }
    }
}