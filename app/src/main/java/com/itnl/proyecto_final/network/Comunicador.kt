package com.itnl.proyecto_final.network

import androidx.fragment.app.Fragment

interface Comunicador {
    fun passData(fragment:Fragment, listaDatos: ArrayList<String>)
}