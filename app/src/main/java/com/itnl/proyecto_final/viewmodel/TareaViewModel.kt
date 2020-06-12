package com.itnl.proyecto_final.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.network.Callback
import com.itnl.proyecto_final.network.FirestoreService
import java.lang.Exception

class TareaViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    var listTarea: MutableLiveData<List<Tarea>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()
    val tarea = Tarea()
    val db = FirebaseFirestore.getInstance()

    fun refresh() {
        getTareasFromFirebase()
    }

    fun getTareasFromFirebase() {
        firestoreService.getTareas(object: Callback<List<Tarea>> {
            override fun onSuccess(result: List<Tarea>?) {
                listTarea.postValue(result)
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