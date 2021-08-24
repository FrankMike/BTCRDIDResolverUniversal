package com.micheli.resolver

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class ServiceConnection(private val url: URL) {

    private var connection: HttpURLConnection? = null

    @JvmName("getJsonString1")
    fun getJsonString(): String {
        var data = ""
        try {
            connection = URL(url.toString()).openConnection() as HttpURLConnection
            data = connection!!.inputStream.bufferedReader().readText()
            println("Data from JSON: $data")
        } catch (e: IOException) {
            println("getJsonStringError: $e.message")
        } finally {
            connection!!.disconnect()
        }
        return data
    }

}