package com.itnl.expotech.view.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

import com.itnl.proyecto_final.modelo.Usuario
import kotlinx.android.synthetic.main.fragment_perfil_detail_dialog.*
import java.text.SimpleDateFormat

import com.itnl.proyecto_final.R

/**
 * A simple [Fragment] subclass.
 */
class PerfilDetailDF : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_detail_dialog, container, false)
    }

}