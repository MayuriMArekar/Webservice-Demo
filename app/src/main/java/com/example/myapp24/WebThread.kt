package com.example.myapp24

import android.os.AsyncTask
import android.os.Handler
import android.os.Message

@Suppress("DEPRECATION")
class WebThread(
    var handler: Handler?
):AsyncTask<Any?,Any?,UserResponse?>(){
    @Deprecated("Deprecated in Java", ReplaceWith("WebUtil.getAllProducts()"))
    override fun doInBackground(vararg params: Any?): UserResponse {
        return WebUtil.getAllUsers()
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: UserResponse?) {
        super.onPostExecute(result)
        val message = Message()
        message.obj = result
        handler?.sendMessage(message)

    }
}