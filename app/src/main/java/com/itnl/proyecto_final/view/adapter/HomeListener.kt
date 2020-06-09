package com.itnl.proyecto_final.view.adapter
import com.itnl.proyecto_final.modelo.Tarea
interface HomeListener {
    fun onTareaClicked(tarea: Tarea, position: Int)
}