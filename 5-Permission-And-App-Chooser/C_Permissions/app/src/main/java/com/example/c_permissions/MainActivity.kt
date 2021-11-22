package com.example.c_permissions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cameraButton = findViewById<Button>(R.id.cameraButton)

        val requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if(it) {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_LONG).show()
                setActivityResult()
                finish()
            } else {
                Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_LONG).show()
            }
        }

        cameraButton.setOnClickListener{
            requestCamera.launch(android.Manifest.permission.CAMERA)
        }
    }

    private fun setActivityResult() {
        val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(camera_intent)

    }
}