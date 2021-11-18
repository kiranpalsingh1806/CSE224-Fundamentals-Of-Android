package com.example.c_pickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgV = findViewById<ImageView>(R.id.imageView)
        val btnP = findViewById<Button>(R.id.btnChooseImage)

        val getI = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                imgV.setImageURI(it)
            }
        )
        btnP.setOnClickListener {
            getI.launch("image/*")
        }
    }
}