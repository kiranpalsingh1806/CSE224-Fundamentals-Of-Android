package com.example.c_appchooser

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApp = findViewById<Button>(R.id.button1)
        val btnApp2 = findViewById<Button>(R.id.button2)
        val btnApp3 = findViewById<Button>(R.id.button3)
        val imageView = findViewById<ImageView>(R.id.imageView)

        btnApp.setOnClickListener {
            val location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
            val mapIntent = Intent(Intent.ACTION_VIEW, location)
            startActivity(mapIntent)
        }

        btnApp2.setOnClickListener {
            var url = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setDataAndType(Uri.parse(url), "text/html")
            val choose = Intent.createChooser(intent, "Share URL")
            startActivity(Intent.createChooser(intent, "Share URL"))
        }


        btnApp3.setOnClickListener {

        }
    }
}