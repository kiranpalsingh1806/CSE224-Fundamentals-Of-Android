package com.example.context_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,)
        listView?.adapter = adapter
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.contextmenu, menu)
        menu?.setHeaderTitle("Select the Action")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.call) {
            Toast.makeText(applicationContext, "Calling Code", Toast.LENGTH_LONG).show()
        } else if( item.itemId == R.id.sms) {
            Toast.makeText(applicationContext, "Sending SMS Code", Toast.LENGTH_LONG).show()
        } else {
            return false
        }
        return true
    }


}