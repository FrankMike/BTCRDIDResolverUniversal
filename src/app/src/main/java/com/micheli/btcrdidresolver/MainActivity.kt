package com.micheli.btcrdidresolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.micheli.resolver.BTCRDIDResolver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        Thread {
            val did: String = BTCRDIDResolver("did:btcr:xz35-jznz-q9yu-ply").resolve()
            println("DID document: $did")
            textView.text = did
        }.start()
    }
}