package com.itnl.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.modelo.Integrante
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBar(findViewById(R.id.tbMain))
        confignav()
    }

    fun confignav(){
        NavigationUI.setupWithNavController(bnvMenu ,Navigation.findNavController(this,R.id.fragContent))
    }
}

