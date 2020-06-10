package com.itnl.proyecto_final.viewmodel

import androidx.lifecycle.ViewModel
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class UsuarioViewModel: ViewModel() {

    fun sendPostRequest(nombre:String, apellido:String,correo:String,contrasenia:String, imagen:String){
        var reqParam = URLEncoder.encode("FirstName","UTF-8") + "=" + URLEncoder.encode(nombre, "UTF-8")
        reqParam += "&" + URLEncoder.encode("LastName", "UTF-8") + "=" + URLEncoder.encode(apellido, "UTF-8")
        reqParam += "&" + URLEncoder.encode("Mail", "UTF-8") + "=" + URLEncoder.encode(correo, "UTF-8")
        reqParam += "&" + URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(contrasenia, "UTF-8")
        reqParam += "&" + URLEncoder.encode("PathImage", "UTF-8") + "=" + URLEncoder.encode(imagen, "UTF-8")
        val mURL = URL("https://mkt-ebay-user.azurewebsites.net/api/AddUser?code=9t/dU62m1OZf8guvJ6qNnpIMqUb4fKcYfKOhYkBH/V92kuVHjVnFTQ==")

        with(mURL.openConnection() as HttpURLConnection){
            requestMethod = "POST"
            val wr = OutputStreamWriter(outputStream);
            wr.write(reqParam)
            wr.flush()

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while(inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response : $response")
            }
        }

    }
}