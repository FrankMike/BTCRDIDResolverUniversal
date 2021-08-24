package com.micheli.resolver

import java.net.URL

class BTCRDIDResolver(private val btcrDiD: String) {

    private val urlString: String = "http://10.0.2.2:8080/1.0/identifiers/"
    private var url: URL? = null
    private var did: String = this.btcrDiD

    fun resolve(): String {
        url = URL(urlString + did)
        val serviceConnection = ServiceConnection(url!!)
        val result = serviceConnection.getJsonString()
        println("result resolve: $result")
        return result
    }

}