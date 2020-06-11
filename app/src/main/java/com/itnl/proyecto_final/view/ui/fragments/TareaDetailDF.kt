package com.itnl.expotech.view.ui.fragments

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import kotlinx.android.synthetic.main.fragment_tarea_detail_dialog.*
import java.text.SimpleDateFormat


/**
 * A simple [Fragment] subclass.
 */
class TareaDetailDF : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tarea_detail_dialog, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarTareaDetail.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarTareaDetail.setTitleTextColor(Color.WHITE)
        toolbarTareaDetail.setNavigationOnClickListener {
            dismiss()
        }

        val tarea = arguments?.getSerializable("tarea") as Tarea
        toolbarTareaDetail.title = "Detalles"

        tfNombreDeTarea_detalle.setText(tarea.nombre)
        tfDescripcionDeTarea_detalle.setText(tarea.descripcion)

        //val pattern = "dd/MM/yyyy hh:mm a"
        /*val anio = SimpleDateFormat("yyyy").toString().toInt()
        val mes = SimpleDateFormat("MM").toString().toInt()
        val dia = SimpleDateFormat("dd").toString().toInt()
        val hora = SimpleDateFormat("hh").toString().toInt()
        val minuto = SimpleDateFormat("mm").toString().toInt()
        val ampm = SimpleDateFormat("a")
        dpFechaEntrega_detalle.updateDate(anio,mes,dia)
        if(hora == null){
            tpHoraEntrega_detalles.hour = hora
            tpHoraEntrega_detalles.minute = minuto
            tpHoraEntrega_detalles.is24HourView
        }
        //val simpleDF = SimpleDateFormat(pattern)*/
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}