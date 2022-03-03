package com.micheli.btcrdidresolver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textInput = findViewById<EditText>(R.id.inputText)
        button.setOnClickListener {
            val message = textInput.text.toString()
            val intent = Intent(this, DDO::class.java).apply {
                putExtra("did", message)
            }
            startActivity(intent)
        }
    }
}