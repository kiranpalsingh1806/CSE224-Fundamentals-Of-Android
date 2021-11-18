package com.example.c_explicitintentdatatransfer

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getResultButton = findViewById<Button>(R.id.getResultButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val secondActivityWithResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult?->
            if(result?.resultCode == RESULT_OK) {
                resultTextView.text = result.data?.getStringExtra("result")
            } else {
                if(result?.resultCode == RESULT_CANCELED) {
                    Toast.makeText(applicationContext, "Back Button Pressed", Toast.LENGTH_LONG).show()
                }
            }
        }

        getResultButton.setOnClickListener {
            val intent = Intent(this, second_activity::class.java)
            secondActivityWithResult.launch(intent)
        }
    }
}