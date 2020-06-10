package com.itnl.expotech.view.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import com.itnl.proyecto_final.viewmodel.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_registro.*
import java.io.ByteArrayOutputStream
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {

    private lateinit var viewModel: UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
        bnvMenu.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegresar.setOnClickListener(){
            (context as MainActivity).changeFragment(InicioSesionFragment.newInstance())
        }
        btnGuardar_perfil.setOnClickListener(){

                var editTextNombre = tfNombre_registro.text.toString()
                var editTextApellido = tfApellido_reigistro.text.toString()
                var editTextCorreo = tfCorreo_registro.text.toString()
                var editTextContrasenia = tfContrasenia_registro.text.toString()
                /*var imageViewFoto = (ivFotoPerfil_registro.drawable as BitmapDrawable).bitmap
                val stream = ByteArrayOutputStream()
                imageViewFoto.compress(Bitmap.CompressFormat.PNG, 90, stream)
                val image = stream.toByteArray()
                var base64 = Base64.getEncoder().encodeToString(image)*/
                println(editTextNombre)

                viewModel.sendPostRequest(editTextNombre,editTextApellido,editTextCorreo,editTextContrasenia,"temporal")


        }

    }

    companion object {
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }

}