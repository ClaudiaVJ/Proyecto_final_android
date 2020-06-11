package com.itnl.proyecto_final.viewmodel

import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.network.FirestoreService
import org.json.JSONArray
import java.io.*
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class UsuarioViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listUsuario: MutableLiveData<List<Usuario>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getUsuariosFromFirebase()
    }

    fun getUsuariosFromFirebase() {
        firestoreService.getUsuarios(object: com.itnl.proyecto_final.network.Callback<List<Usuario>> {
            override fun onSuccess(result: List<Usuario>?) {
                listUsuario.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}
