package com.itnl.expotech.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.view.ui.activities.LoginActivity
import kotlinx.android.synthetic.main.fragment_perfil_detail_dialog.*
import org.jetbrains.anko.support.v4.alert

/**
 * A simple [Fragment] subclass.
 */
class PerfilDetailDF : Fragment() {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }*/
    var datos = kotlin.collections.ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_perfil_detail_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datos = (activity as LoginActivity).obtenerDatos()

        tfNombre_perfil.setText(datos[0])
        tfApellido_perfil.setText(datos[1])
        tfCorreo_perfil.setText(datos[2])
        
    }

    /*override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }*/

}