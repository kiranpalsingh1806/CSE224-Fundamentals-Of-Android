package com.example.popup_menu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnShow)

        btn.setOnClickListener{
            val popup = PopupMenu(this, btn)
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
    }
}

