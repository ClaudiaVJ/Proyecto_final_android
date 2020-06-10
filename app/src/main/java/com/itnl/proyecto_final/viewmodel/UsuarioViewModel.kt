package com.itnl.proyecto_final.viewmodel

import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import com.itnl.proyecto_final.modelo.Usuario
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import org.json.JSONArray
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class UsuarioViewModel: ViewModel() {

    fun sendPostRequest(nombre:String, apellido:String,correo:String,contrasenia:String, imagen:String){
        val url = "https://mkt-ebay-user.azurewebsites.net/api/AddUser?code=9t/dU62m1OZf8guvJ6qNnpIMqUb4fKcYfKOhYkBH/V92kuVHjVnFTQ=="
        AsyncTaskHandleJson().execute(url)
    }
    inner class AsyncTaskHandleJson : AsyncTask<String,String,String>(){
        override fun doInBackground(vararg url: String?): String {
            var text: String
            val conection = URL(url[0]).openConnection() as HttpURLConnection

            try{
                conection.connect()
                text = conection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            }finally {
                conection.disconnect()
            }

            return text
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            handleJson(result)
        }
    }

    private fun handleJson(jsonString: String?){
        val jsonArray = JSONArray(jsonString)
        val list = ArrayList<String>()
        var x = 0
        while(x < jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(x)

            x++
        }
    }
}
