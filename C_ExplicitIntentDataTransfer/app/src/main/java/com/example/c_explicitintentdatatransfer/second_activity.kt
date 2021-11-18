package com.example.c_explicitintentdatatransfer

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class second_activity : AppCompatActivity() {
    lateinit var sendResultButton: Button
    lateinit var resultEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        sendResultButton = findViewById(R.id.sendResultButton)
        resultEditText = findViewById(R.id.resultEditText)

        sendResultButton.setOnClickListener {
            setActivityResult()
            finish()
        }
    }
    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }
    private fun setActivityResult() {
        val intent = Intent()
        var out:String = resultEditText.text.toString()
        var outp:String = "The result text is : $out "
        intent.putExtra("result", outp)
        setResult(Activity.RESULT_OK, intent)
    }
}