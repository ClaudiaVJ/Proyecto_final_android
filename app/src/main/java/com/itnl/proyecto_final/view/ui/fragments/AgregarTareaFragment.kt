package com.itnl.expotech.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.view.ui.activities.LoginActivity
import kotlinx.android.synthetic.main.fragment_agregar_tarea.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AgregarTareaFragment : Fragment() {

    var correoDeUsuario: String? = ""
    var datos = kotlin.collections.ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agregar_tarea, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datos = (activity as LoginActivity).obtenerDatos()
        correoDeUsuario = datos[2]

        btnAgregarTarea.setOnClickListener(){
            val db = FirebaseFirestore.getInstance()
            var nombreTarea = tfNombreDeTarea_agregar.text.toString()
            var descripcion = tfDescripcionDeTarea_agregar.text?.toString()
            var fecha: String
            val datePicker = dpFechaEntrega_agregar
            val fechaEntrega = Calendar.getInstance()
            datePicker.init(fechaEntrega.get(Calendar.YEAR), fechaEntrega.get(Calendar.MONTH), fechaEntrega.get(Calendar.DAY_OF_MONTH)){
                view, year, month, day->
                fechaEntrega.set(year, month, day)
            }

            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
            fecha = simpleDateFormat.format(fechaEntrega.getTime())

            //val date: Date = simpleDateFormat.parse(fecha)

            if(nombreTarea != "" && correoDeUsuario != "" && fecha != ""){
                val jsonArr = JSONArray("[{'correo' : '${correoDeUsuario}', 'nombre' : '${nombreTarea}', 'descripcion' : '${descripcion}', 'fechaEntrega' : '${fecha}'}]")

                    val aux = jsonArr.get(0) as JSONObject
                    var tarea = Tarea()
                    tarea.correo = aux.getString("correo")
                    tarea.nombre = aux.getString("nombre")
                    tarea.descripcion = aux.getString("descripcion")
                    tarea.fechaDeEntrega = aux.getString("fechaEntrega")

                    //agregar a firestore el objeto
                    db.collection("tareas").document().set(tarea)
                alert("Tarea agregada correctamente.") {
                    negativeButton("Continuar"){toast("yes")}
                }.show()
            }else{
                alert("La tarea debe tener al menos un nombre y una fecha. ${correoDeUsuario}, ${nombreTarea}") {
                    negativeButton("Entendido"){toast("yes")}
                }.show()
            }



        }
    }


}