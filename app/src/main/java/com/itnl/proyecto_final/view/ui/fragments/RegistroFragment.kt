package com.itnl.expotech.view.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itnl.expotech.view.ui.fragments.RegistroFragment.Companion.newInstance
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.view.adapter.HomeAdapter
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import com.itnl.proyecto_final.view.ui.fragments.HomeFragment
import com.itnl.proyecto_final.viewmodel.UsuarioViewModel
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_registro.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegresar.setOnClickListener(){
            (context as MainActivity).changeFragment(InicioSesionFragment.newInstance())
        }




    }

    companion object {
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }
}