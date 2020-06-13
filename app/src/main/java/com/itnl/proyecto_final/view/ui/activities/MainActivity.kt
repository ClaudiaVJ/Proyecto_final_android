package com.itnl.proyecto_final.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import com.itnl.expotech.view.ui.fragments.AgregarTareaFragment
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.modelo.Integrante
import com.itnl.proyecto_final.network.Comunicador
import com.itnl.proyecto_final.view.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_inicio_sesion.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), Comunicador {

    public lateinit var com: Comunicador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_inicio_sesion)
        setActionBar(findViewById(R.id.tbMain))
        supportActionBar?.hide()
        var progressbar = progressBar2

        btnRegistrarse.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(){
        val db = FirebaseFirestore.getInstance()
        val correo = tfCorreo_iniciar_sesion.text.toString()
        val contrasenia = tfContrasenia_iniciar_sesion.text.toString()
        var listaDatos = kotlin.collections.ArrayList<String>()

        if(correo != "" && contrasenia != ""){
            var progressbar = progressBar2
            progressbar.visibility = View.VISIBLE
            val usuarioRef = db.collection("usuarios").whereEqualTo("correo", correo)

            usuarioRef.get().addOnSuccessListener { result ->
                if(result != null){
                    for(document in result){
                        if(document.get("contrasenia") == contrasenia){
                            listaDatos.add(document.get("nombre").toString())
                            listaDatos.add(document.get("apellido").toString())
                            listaDatos.add(document.get("correo").toString())
                            listaDatos.add(document.get("contrasenia").toString())
                            listaDatos.add(document.id)

                            alert("Login exitoso ${listaDatos[0]}") {
                                negativeButton("Entendido"){toast("yes")}
                            }.show()
                            //val fragmentHome = HomeFragment()
                            //val bundle = Bundle()
                            //bundle.putStringArrayList("usuario",listaDatos)
                            //fragmentHome.arguments = bundle

                            //(this as MainActivity).changeFragment(fragmentHome)
                            val intent = Intent(this, LoginActivity::class.java)
                            intent.putStringArrayListExtra("usuario",listaDatos)
                            startActivity(intent)
                            //com.passData(fragmentHome, listaDatos)
                        }else{
                            alert("La combinacion correo/contraseña no es correcta") {
                                negativeButton("Entendido"){toast("Intentelo nuevamente")}
                            }.show()
                        }
                    }
                }else{
                    alert("Esta cuenta no existe") {
                        negativeButton("Entendido"){toast("Intentelo nuevamente")}
                    }.show()
                }
            }
        }else{
            alert("Verifique que ha ingresado los datos correctos") {
                title = "Alerta"
                negativeButton("Entendido"){toast("Intentelo nuevamente")}
            }.show()
        }

    }

    fun login(view: View){
        loginUser()
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit()
    }

    override fun passData(fragment: Fragment, listaDatos: kotlin.collections.ArrayList<String>) {
        val bundle = Bundle()
        bundle.putStringArrayList("usuario",listaDatos)
        fragment.arguments = bundle
        val transaction = this.supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit()
        //fragment.arguments = bundle
    }

}
