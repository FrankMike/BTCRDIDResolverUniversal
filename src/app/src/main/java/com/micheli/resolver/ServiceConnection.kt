package com.micheli.resolver

import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.SocketException
import java.net.URL

class ServiceConnection(private val url: URL) {

    private var connection: HttpURLConnection? = null

    private fun connect() {
        try {
            connection = url.openConnection() as HttpURLConnection
            connection!!.doOutput = false
            connection!!.doInput = true
            connection!!.useCaches = false
            connection!!.requestMethod = "GET"
            connection!!.setRequestProperty("Content-Type", "application/json")
            connection!!.setRequestProperty("charset", "utf-8")
            connection!!.connect()
            System.out.println("Connected")
        } catch(e: SocketException) {
            System.err.println("SocketException: ${e.message}")
        } catch(e: IOException) {
            System.err.println("IOException Connection: ${e.message}")
        }
    }

    public val jsonString: String
        get() {
            val response = StringBuilder()
            val responseJSON: String
            try {
                connect()
                val status = connection!!.responseCode
                if (status != 200) {
                    throw IOException("Error: $status")
                } else {
                    val input = BufferedReader(InputStreamReader(connection!!.inputStream))
                    var  inputLine: String?
                    while(input.readLine().also{ inputLine = it } != null) {
                        response.append(inputLine)
                    }
                    input.close()
                }
            } catch (e: IOException) {
                System.err.println("IOException JSON String: ${e.message}")
            } finally {
                if (connection != null) {
                    connection!!.disconnect()
                }
                responseJSON = response.toString()
                System.out.println("result jsonString: " + responseJSON)
            }
            return responseJSON
        }

    public val jsonObject: JSONObject?
        get() {
            var response: JSONObject? = null
            try {
                response = JSONObject(jsonString)
            } catch(e: JSONException){
                System.out.println("JSONException: ${e.message}")
            }
            return response
        }

}