package com.example.c_intentswithbutton

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat.startActivityForResult

import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnNavigate);
        val btn1 = findViewById<Button>(R.id.btnCamera);
        val btn2 = findViewById<Button>(R.id.btnCall);
        val btn3 = findViewById<Button>(R.id.btnContact);
        val btn4 = findViewById<Button>(R.id.btnGallery);
        val btn5 = findViewById<Button>(R.id.btnDialer)


        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com"))
            startActivity(intent)
        }

        btn1.setOnClickListener {
            val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(camera_intent);
        }

        btn2.setOnClickListener {
            val intentCallLog = Intent(Intent.ACTION_VIEW)
            intentCallLog.setType(CallLog.Calls.CONTENT_TYPE);
            startActivity(intentCallLog);
        }

        btn3.setOnClickListener {
            val intentCallLog = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intentCallLog)
        }

        btn4.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.type = "image/*"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

        btn5.setOnClickListener {
            val mobileNumber = "+919834254673"
            val dialerIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", mobileNumber, null))
            startActivity(dialerIntent)
        }
    }
}