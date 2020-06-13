package com.itnl.proyecto_final.view.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.network.Comunicador
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert

class LoginActivity : AppCompatActivity(), Comunicador {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var datos = kotlin.collections.ArrayList<String>()
        datos = intent.getStringArrayListExtra("usuario")

            setContentView(R.layout.activity_main)
            confignav()
            setActionBar(findViewById(R.id.tbMain))
            supportActionBar?.hide()
    }


    fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit()
    }

    fun confignav(){
        NavigationUI.setupWithNavController(bnvMenu ,Navigation.findNavController(this,R.id.fragContent))
    }

    override fun passData(fragment: Fragment, listaDatos: kotlin.collections.ArrayList<String>) {
        val bundle = Bundle()
        bundle.putStringArrayList("usuario",listaDatos)
        fragment.arguments = bundle
        val transaction = this.supportFragmentManager.beginTransaction().replace(R.id.relativeLayout, fragment).commit()
        //fragment.arguments = bundle

    }

}

