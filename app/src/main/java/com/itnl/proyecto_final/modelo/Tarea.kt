package com.itnl.proyecto_final.modelo

import java.io.Serializable
import java.util.*

class Tarea {
    var idTarea: Int = 0
    lateinit var nombre: String
    lateinit var descripcion: String
    lateinit var fechaDeEntrega: Date
    var cantidadIntegrantes: Int = 0
}