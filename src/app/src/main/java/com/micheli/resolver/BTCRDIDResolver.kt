package com.micheli.resolver

import java.net.URL

class BTCRDIDResolver(private val btcrDiD: String) {

    private val localResolverEndpoint: String = "http://10.0.2.2:8080/1.0/identifiers/"
    private val universalResolverEndpoint: String = "https://dev.uniresolver.io/1.0/identifiers/"
    private val danubeTechEndpoint: String = "https://resolver.svip.danubetech.com/1.0/identifiers/"
    private val godiddyEndpoint: String = "https://api.godiddy.com/0.1.0/universal-resolver/identifiers/"

    private var url: URL? = null
    private var did: String = this.btcrDiD

    fun resolve(): String {
        val endpoint = universalResolverEndpoint
        url = URL(endpoint + did)
        val serviceConnection = ServiceConnection(url!!)
        val result = serviceConnection.getJsonString()
        println("result resolve: $result")
        return result
    }

}