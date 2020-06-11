package com.itnl.proyecto_final.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itnl.proyecto_final.modelo.Integrante
import com.itnl.proyecto_final.network.FirestoreService
import java.lang.Exception

class IntegranteViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listIntegrante: MutableLiveData<List<Integrante>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getIntegranteFromFirebase()
    }

    fun getIntegranteFromFirebase() {
        firestoreService.getIntegrantes(object: com.itnl.proyecto_final.network.Callback<List<Integrante>> {
            override fun onSuccess(result: List<Integrante>?) {
                listIntegrante.postValue(result)
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