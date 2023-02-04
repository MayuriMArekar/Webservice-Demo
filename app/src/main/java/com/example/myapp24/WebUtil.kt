package com.example.myapp24

import android.util.Log
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebUtil {
    companion object {
        fun getAllUsers(): UserResponse {
            val getProductApiURL = URL("https://dummyjson.com/users")
            val httpURLConnection = getProductApiURL.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.connect()

            val resReader = InputStreamReader(httpURLConnection.inputStream)
            val gson = Gson()
            val userResponse = gson.fromJson(
                resReader,
                UserResponse::class.java
            )
            Log.e("tag", userResponse.toString())
            for (product in userResponse.users) {
                Log.e("tag", "$product")
            }
            return userResponse
        }
    }
}