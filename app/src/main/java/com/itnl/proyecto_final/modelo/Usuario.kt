package com.itnl.proyecto_final.modelo

import java.io.Serializable

class Usuario : Serializable {
    lateinit var nombre: String
    lateinit var apellido: String
    lateinit var correo: String
    lateinit var contrasenia: String

}