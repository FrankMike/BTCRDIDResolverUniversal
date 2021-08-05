package com.micheli.btcrdidresolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.micheli.resolver.BTCRDIDResolver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView = findViewById<TextView>(R.id.textView)
        var did: String = BTCRDIDResolver("did:btcr:xz35-jznz-q9yu-ply").resolve()
        System.out.println("DID: " + did)
        textView.text = did
    }
}