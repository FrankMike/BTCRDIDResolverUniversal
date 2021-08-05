package com.micheli.resolver

//import org.json.JSONObject
import java.net.URL

class BTCRDIDResolver(private val btcrDiD: String) {

    private val urlString: String = "http://localhost:8080/1.0/identifiers/"
    private var url: URL? = null
    //private var jsonObject: JSONObject? = null
    private var did: String = btcrDiD

    fun resolve(): String {
        url = URL(urlString + did)
        var serviceConnection = ServiceConnection(url!!)
        var result = serviceConnection.jsonString
        System.out.println("result resolve: " + result)
        return result
    }

}