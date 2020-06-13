package com.itnl.expotech.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.network.Comunicador
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import com.itnl.proyecto_final.view.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.fragment_inicio_sesion.*


/**
 * A simple [Fragment] subclass.
 */
class InicioSesionFragment : Fragment() {

    public lateinit var com: Comunicador


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
        /*
        btnIniciarSesion.setOnClickListener(){

            val db = FirebaseFirestore.getInstance()
            val correo = tfCorreo_iniciar_sesion.text.toString()
            val contrasenia = tfContrasenia_iniciar_sesion.text.toString()
            var listaDatos = kotlin.collections.ArrayList<String>()

            if(correo != "" && contrasenia != ""){
                val usuarioRef = db.collection("usuarios").whereEqualTo("correo", correo)
                usuarioRef.get().addOnSuccessListener { result ->
                    if(result != null){
                        for(document in result){
                            if(document.get("contrasenia") == contrasenia){
                                listaDatos.add(document.get("nombre").toString())
                                listaDatos.add(document.get("apellido").toString())
                                listaDatos.add(document.get("correo").toString())
                                listaDatos.add(document.get("contrasenia").toString())

                                alert("Login exitoso") {
                                    title = "Alerta"
                                    negativeButton("Entendido"){toast("yes")}
                                }.show()
                                val fragmentHome = HomeFragment()
                                val bundle = Bundle()
                                bundle.putStringArrayList("usuario",listaDatos)
                                fragmentHome.arguments = bundle
                                //(context as MainActivity).changeFragment(fragmentHome)

                                com.passData(fragmentHome, listaDatos)
                            }else{
                                alert("La combinacion correo/contraseña no es correcta.") {
                                    negativeButton("Entendido"){toast("yes")}
                                }.show()
                            }
                        }
                    }else{
                        alert("Esta cuenta no existe.") {
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



        }*/
    }

    companion object{
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }
}