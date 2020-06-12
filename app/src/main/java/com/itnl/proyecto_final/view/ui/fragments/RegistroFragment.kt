package com.itnl.expotech.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_registro.*
import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast

class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
        /*database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("usuarios")
        progressBar = ProgressBar(requireActivity())*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegresar.setOnClickListener(){
            (context as MainActivity).changeFragment(InicioSesionFragment.newInstance())
        }

        btnCrearCuenta_registro.setOnClickListener(){
            val db = FirebaseFirestore.getInstance()

            val nombre = tfNombre_registro.text.toString()
            val apellido = tfApellido_reigistro.text.toString()
            val correo = tfCorreo_registro.text.toString()
            val contrasenia = tfContrasenia_registro.text.toString()

            if(nombre != "" && apellido != "" && correo != "" && contrasenia != ""){
                val usuarios = db.collection("usuarios")
                val usuario = hashMapOf(
                    "nombre" to nombre,
                    "apellido" to apellido,
                    "correo" to correo,
                    "contrasenia" to contrasenia
                )
                alert("Registro exitoso") {
                    title = "Registro correcto"
                    negativeButton("Entendido"){toast("yes")}
                }.show()

                usuarios.document().set(usuario)
            }else{
                alert("Alerta de regitro") {
                    title = "Alerta"
                    negativeButton("Entendido"){toast("yes")}
                }.show()
            }


        }
    }
    companion object {
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }
}



