package com.itnl.proyecto_final.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
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

    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit()
    }

    fun confignav(){
        NavigationUI.setupWithNavController(bnvMenu ,Navigation.findNavController(this,R.id.fragContent))

    }


}

