package com.itnl.proyecto_final.view.adapter

interface RegistroListener {
    fun addNewUser(idUsuario: Int, nombre: String, apellido: String, contrasenia: String, correo: String, foto: String)
}