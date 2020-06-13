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
        datos = arguments?.getStringArrayList("usuario") as ArrayList<String>
        alert { message = "${datos[0]}" }


        /*val usuario = arguments?.getSerializable("usuario") as Usuario
        toolbar.title = "Perfil"
        toolbar.setTitleTextColor(Color.WHITE)

        tfNombre_perfil.setText(usuario.nombre)
        tfApellido_perfil.setText(usuario.apellido)
        tfCorreo_perfil.setText(usuario.correo)
        tfContrasenia_perfil.setText(usuario.contrasenia)
        Glide.with(this)
            .load(usuario.foto)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailPerfilImage)*/
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener {
            dismiss()
        }*/

        val usuario = arguments?.getSerializable("usuario") as Usuario
        toolbar.title = "Perfil"
        toolbar.setTitleTextColor(Color.WHITE)

        tfNombre_perfil.setText(usuario.nombre)
        tfApellido_perfil.setText(usuario.apellido)
        tfCorreo_perfil.setText(usuario.correo)
        tfContrasenia_perfil.setText(usuario.contrasenia)
        Glide.with(this)
            .load(usuario.foto)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailPerfilImage)

         /*ivDetailSpeakerTwitter.setOnClickListener {
            var intent: Intent

            try {
                context?.packageManager?.getPackageInfo("com.twitter.android", 0)
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=${speaker.twitter}"))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://twitter.com/${speaker.twitter}")
                )
            }
            startActivity(intent)
        }*/
    }*/

    /*override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }*/

}