package com.itnl.expotech.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_inicio_sesion.*

/**
 * A simple [Fragment] subclass.
 */
class InicioSesionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegistrarse.setOnClickListener(){
            (context as MainActivity).changeFragment(RegistroFragment.newInstance())
        }

    }

    companion object{
        fun newInstance(): InicioSesionFragment{
            return InicioSesionFragment()
        }
    }



}