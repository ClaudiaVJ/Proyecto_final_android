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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.tbMain))
        confignav()

        val jsonArrUsuarios = JSONArray("[\n" +
                "            {\n" +
                "                'IdUsuario' : 0,\n" +
                "                'nombre' : 'Claudia',\n" +
                "                'apellido' : 'Verdugo',\n" +
                "                'correo' : 'clau@gmail.com',\n" +
                "                'contrasenia' : '123',\n" +
                "                'imagen' : 'alguna ruta',\n" +
                "            },\n" +
                "            {\n" +
                "                'IdUsuario' : 2,\n" +
                "                'nombre' : 'Rodolfo',\n" +
                "                'apellido' : 'Gallardo',\n" +
                "                'correo' : 'rod@gmail.com',\n" +
                "                'contrasenia' : '1234',\n" +
                "                'imagen' : 'alguna ruta',\n" +
                "            },\n" +
                "            {\n" +
                "                 'IdUsuario' : 3,\n" +
                "                'nombre' : 'Yesenia',\n" +
                "                'apellido' : 'Mendoza',\n" +
                "                'correo' : 'yes@gmail.com',\n" +
                "                'contrasenia' : '12345',\n" +
                "                'imagen' : 'alguna ruta',\n" +
                "            }\n" +
                "        ]")

        val jsonArrTareas = JSONArray("[\n" +
                "            {\n" +
                "                'IdTarea' : 1,\n" +
                "                'IdUsuario' : 1,\n" +
                "                'nombre' : 'Proyecto de android',\n" +
                "                'descripcion' : 'Una tarea que me confunde',\n" +
                "                'fechaDeEntrega' : '2020-05-28',\n" +
                "            },\n" +
                "            {\n" +
                "                'IdTarea' : 2,\n" +
                "                'IdUsuario' : 1,\n" +
                "                'nombre' : 'Proyecto de ios',\n" +
                "                'descripcion' : 'Una tarea que me confunde',\n" +
                "                'fechaDeEntrega' : '2020-05-28',\n" +
                "            },\n" +
                "            {\n" +
                "                'IdTarea' : 3,\n" +
                "                'IdUsuario' : 1,\n" +
                "                'nombre' : 'Tarea de semaforo',\n" +
                "                'descripcion' : 'Una tarea que me confunde',\n" +
                "                'fechaDeEntrega' : '2020-05-28',\n" +
                "            }\n" +
                "        ]")

        val jsonArrIntegrantes= JSONArray("[\n" +
                "            {\n" +
                "                'IdIntegrante' : 1,\n" +
                "                'IdTarea' : 1,\n" +
                "                'nombre' : 'Heidy',\n" +
                "                'apellido' : 'Rivera',\n" +
                "            },\n" +
                "            {\n" +
                "                'IdIntegrante' : 2,\n" +
                "                'IdTarea' : 1,\n" +
                "                'nombre' : 'Luis',\n" +
                "                'apellido' : 'Grimaldo',\n" +
                "            }\n" +
                "        ]")

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
        }
    }

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit()
    }

    fun confignav(){
        NavigationUI.setupWithNavController(bnvMenu ,Navigation.findNavController(this,R.id.fragContent))
    }


}

