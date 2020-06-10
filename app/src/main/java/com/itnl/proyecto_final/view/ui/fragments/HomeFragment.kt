package com.itnl.proyecto_final.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.view.adapter.HomeAdapter
import com.itnl.proyecto_final.view.adapter.HomeListener

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeListener {

    private lateinit var homeAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onTareaClicked(tarea: Tarea, position: Int) {
        TODO("Not yet implemented")
    }

}