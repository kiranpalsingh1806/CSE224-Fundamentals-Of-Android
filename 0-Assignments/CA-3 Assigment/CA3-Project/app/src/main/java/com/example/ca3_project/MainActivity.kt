package com.example.ca3_project

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lv = findViewById<ListView>(R.id.myListView)

        var a = arrayOf("Profile", "Message")
        var ab = ArrayAdapter(this, android.R.layout.simple_list_item_1, a);
        lv.adapter = ab

        lv.setOnItemClickListener{adapterView, view, position, id ->
            val str = adapterView.getItemAtPosition(position) as String
            Toast.makeText(this, "You selected $str", Toast.LENGTH_LONG).show()
        }


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




        val btnPop = findViewById<Button>(R.id.btnPopup)

        btnPop.setOnClickListener{
            val popup = PopupMenu(this, btnPop)
            popup.menuInflater.inflate(R.menu.popupmenu, popup.menu)

            popup.setOnMenuItemClickListener {
                Toast.makeText(applicationContext, "You clicked : " + it.title, Toast.LENGTH_LONG).show()
                if (it.title.equals("Search")){
                    val url = "http://www.google.com"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                true
            }
            popup.show()
        }

        val button = findViewById<Button>(R.id.contactMeButton)

        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialogTitle)
            builder.setMessage(R.string.dialogMessage)

            builder.setPositiveButton("Call"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Calling",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"Call Cancelled",Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Hang up"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Hanged Up",Toast.LENGTH_LONG).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        var btn1 = findViewById<Button>(R.id.likeButton)
        var likes = 0

        btn1.setOnClickListener {
            var pf:TextView = TextView(this)
            likes++
            pf.text = "$likes people liked your profile"
            pf.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            Toast.makeText(this, "Thank you for like", Toast.LENGTH_LONG).show()
            linearLayout.addView(pf)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return true
    }

    private fun setActivityResult() {
        val camera_intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(camera_intent)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when(id) {
            R.id.Settings -> {
                Toast.makeText(applicationContext, "Settings Selected", Toast.LENGTH_LONG)
                    .show()
                true
            }
            R.id.Play -> {
                Toast.makeText(applicationContext, "Play Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.Pause -> {
                Toast.makeText(applicationContext, "Pause Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.Exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
