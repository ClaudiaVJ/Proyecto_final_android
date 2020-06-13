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
import kotlinx.android.synthetic.main.fragment_registro.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class RegisterActivity : AppCompatActivity(), Comunicador {

    public lateinit var com: Comunicador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_registro)
        setActionBar(findViewById(R.id.tbMain))
        supportActionBar?.hide()

        btnCrearCuenta_registro.setOnClickListener(){
            registrarUsuario()
        }
    }

    private fun registrarUsuario(){
        val db = FirebaseFirestore.getInstance()
        val nombre = tfNombre_registro.text.toString()
        val apellido = tfApellido_reigistro.text.toString()
        val correo = tfCorreo_iniciar_sesion.text.toString()
        val contrasenia = tfContrasenia_iniciar_sesion.text.toString()

        if(correo != "" && contrasenia != "" && apellido != "" && nombre != ""){
            val usuarioRef = db.collection("usuarios").whereEqualTo("correo", correo)
            usuarioRef.get().addOnSuccessListener { result ->
                if(result != null){
                    alert("Ya existe una cuenta registrada con ese correo.") {
                        title = "Alerta"
                        negativeButton("Entendido"){toast("yes")}
                    }.show()
                }else{
                    val jsonArr = JSONArray("[{'apellido' : '${apellido}', 'contrasenia' : '${contrasenia}', 'correo' : '${correo}', 'nombre' : '${nombre}'}]")

                    val aux = jsonArr.get(0) as JSONObject
                    var usuario = Usuario()
                    usuario.correo = aux.getString("correo")
                    usuario.nombre = aux.getString("nombre")
                    usuario.apellido = aux.getString("apellido")
                    usuario.contrasenia = aux.getString("contrasenia")

                    //agregar a firestore el objeto
                    db.collection("usuarios").document().set(usuario)
                    alert("Registro exitoso") {
                        negativeButton("Entendido"){toast("Puede iniciar sesion ahora.")}
                    }.show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }else{
            alert("Debe rellenar todos los campos.") {
                negativeButton("Entendido"){toast("yes")}
            }.show()
        }

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
