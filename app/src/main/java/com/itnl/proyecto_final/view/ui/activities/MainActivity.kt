package com.itnl.proyecto_final.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.modelo.Integrante
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    var idusuario = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.tbMain))
        confignav()
        /*val jsonArrUsuarios = JSONArray("[{'IdUsuario' : 0, 'nombre' : 'Claudia', 'apellido' : 'Verdugo','correo' : 'clau@gmail.com','contrasenia' : '123','imagen' : 'alguna ruta'}, " +
                "{'IdUsuario' : 2,'nombre' : 'Rodolfo','apellido' : 'Gallardo','correo' : 'rod@gmail.com','contrasenia' : '1234','imagen' : 'alguna ruta'}," +
                "{'IdUsuario' : 3,'nombre' : 'Yesenia','apellido' : 'Mendoza','correo' : 'yes@gmail.com','contrasenia' : '12345','imagen' : 'alguna ruta'}]")

        val jsonArrTareas = JSONArray("[{'IdTarea' : 1,'IdUsuario' : 1,'nombre' : 'Proyecto de android','descripcion' : 'Una tarea que me confunde','fechaDeEntrega' : '2020-05-28'}," +
                "{'IdTarea' : 2,'IdUsuario' : 1,'nombre' : 'Proyecto de ios','descripcion' : 'Una tarea que me confunde','fechaDeEntrega' : '2020-05-28'}," +
                "{'IdTarea' : 3,'IdUsuario' : 1, 'nombre' : 'Tarea de semaforo','descripcion' : 'Una tarea que me confunde','fechaDeEntrega' : '2020-05-28'}]")

        val jsonArrIntegrantes = JSONArray("[{'IdIntegrante' : 1,'IdTarea' : 1,'nombre' : 'Heidy','apellido' : 'Rivera'}," +
                "{'IdIntegrante' : 2,'IdTarea' : 1,'nombre' : 'Luis','apellido' : 'Grimaldo'}]")
        */
        /*
        // acceder a la bd y crear una instancia
        val firebaseFirestore = FirebaseFirestore.getInstance()
        // recorrer el arreglo jason desde 0 hasta el tamaño del arreglo.
        for (i in 0 until jsonArrUsuarios.length()) {
            // por cada objeto json...
            val aux = jsonArrUsuarios.get(i) as JSONObject
            var usuario = Usuario()
            usuario.idUsuario = aux.getString("IdUsuario").toInt()
            usuario.nombre = aux.getString("nombre")
            usuario.apellido = aux.getString("apellido")
            usuario.correo = aux.getString("correo")
            usuario.contrasenia = aux.getString("contrasenia")
            usuario.foto = aux.getString("imagen")

            //agregar a firestore el objeto
            firebaseFirestore.collection("usuarios").document().set(usuario)
        }


        for(i in 0 until jsonArrTareas.length()) {
            val aux = jsonArrTareas.get(i) as JSONObject
            var tarea = Tarea()
            tarea.idTarea = aux.getString("IdTarea").toInt()
            tarea.idUsuario = aux.getString("IdUsuario").toInt()
            tarea.nombre = aux.getString("nombre")
            tarea.descripcion = aux.getString("descripcion")
            tarea.fechaDeEntrega = aux.getString("fechaDeEntrega")

            firebaseFirestore.collection("tareas").document().set(tarea)
        }

        for(i in 0 until jsonArrIntegrantes.length()) {
            val aux = jsonArrIntegrantes.get(i) as JSONObject
            var integrante = Integrante()
            integrante.idIntegrante = aux.getString("IdIntegrante").toInt()
            integrante.idTarea = aux.getString("IdTarea").toInt()
            integrante.nombre = aux.getString("nombre")
            integrante.apellido = aux.getString("apellido")

            firebaseFirestore.collection("integrantes").document().set(integrante)
        }*/
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit()
    }

    fun confignav(){
        NavigationUI.setupWithNavController(bnvMenu ,Navigation.findNavController(this,R.id.fragContent))
    }


}

