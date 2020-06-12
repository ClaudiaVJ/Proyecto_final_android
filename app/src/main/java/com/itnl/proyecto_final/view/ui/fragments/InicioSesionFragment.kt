package com.itnl.expotech.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_inicio_sesion.*
import kotlinx.android.synthetic.main.fragment_registro.*


/**
 * A simple [Fragment] subclass.
 */
class InicioSesionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegistrarse.setOnClickListener(){
            (context as MainActivity).changeFragment(RegistroFragment.newInstance())
        }

        btnIniciarSesion.setOnClickListener(){
            val db = FirebaseFirestore.getInstance()
            val correo = tfCorreo_iniciar_sesion.text.toString()
            val contrasenia = tfContrasenia_iniciar_sesion.text.toString()

            if(correo != "" && contrasenia != ""){
                val usuarioRef = db.collection("usuarios").whereEqualTo("correo", correo)
                usuarioRef.get().addOnSuccessListener { documentSnapshot ->
                    if(documentSnapshot != null){
                        val usuario = documentSnapshot.toObjects(Usuario::class.java)
                        alert("${usuario}") {
                            title = "Alerta"
                            negativeButton("Entendido"){toast("yes")}
                        }.show()
                    }
                }

            }else{
                alert("El usuario no existe.") {
                    title = "Alerta"
                    negativeButton("Entendido"){toast("yes")}
                }.show()
            }



        }
    }

    companion object{
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }





}