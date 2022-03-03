package com.micheli.btcrdidresolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.micheli.resolver.BTCRDIDResolver

class DDO : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ddo)
        Thread {
            val message = intent.getStringExtra("did")
            val ddo = findViewById<TextView>(R.id.textView)
            val resolver = message?.let { BTCRDIDResolver(it) }
            val ddoString = resolver?.resolve()
            ddo.apply {
                text = ddoString
            }
        }.start()
    }
}