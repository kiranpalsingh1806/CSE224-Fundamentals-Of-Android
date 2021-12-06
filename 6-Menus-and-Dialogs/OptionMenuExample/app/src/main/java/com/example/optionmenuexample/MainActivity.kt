package com.example.optionmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.optionmenu, menu)
            return true
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