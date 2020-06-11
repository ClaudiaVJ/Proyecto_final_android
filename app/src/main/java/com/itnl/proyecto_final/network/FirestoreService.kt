package com.itnl.proyecto_final.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.modelo.Integrante

const val USUARIOS_COLLECTION_NAME = "usuarios"
const val TAREAS_COLLECTION_NAME = "tareas"
const val INTEGRANTES_COLLECTION_NAME = "integrantes"


class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getTareas(callback: Callback<List<Tarea>>) {
        firebaseFirestore.collection(TAREAS_COLLECTION_NAME)
            .orderBy("IdTarea")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Tarea::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getUsuarios(callback: Callback<List<Usuario>>) {
        firebaseFirestore.collection(USUARIOS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Usuario::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getIntegrantes(callback: Callback<List<Integrante>>) {
        firebaseFirestore.collection(INTEGRANTES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Integrante::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}