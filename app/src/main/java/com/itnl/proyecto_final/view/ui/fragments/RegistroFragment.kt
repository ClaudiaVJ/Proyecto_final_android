package com.itnl.expotech.view.ui.fragments

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.itnl.expotech.view.ui.fragments.RegistroFragment.Companion.newInstance
import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.view.adapter.HomeAdapter
import com.itnl.proyecto_final.view.ui.activities.MainActivity
import com.itnl.proyecto_final.view.ui.fragments.HomeFragment
import com.itnl.proyecto_final.viewmodel.TareaViewModel
import com.itnl.proyecto_final.viewmodel.UsuarioViewModel
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_registro.*
import org.json.JSONArray
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*
import kotlin.properties.Delegates


/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {

    private lateinit var viewModel: UsuarioViewModel
    private lateinit var txtName: EditText
    private lateinit var txtLastName: EditText
    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var  progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    private var firstName by Delegates.notNull<String>()
    private var lastName by Delegates.notNull<String>()
    private var email by Delegates.notNull<String>()
    private var password by Delegates.notNull<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
        /*database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("usuarios")
        progressBar = ProgressBar(requireActivity())*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegresar.setOnClickListener(){
            (context as MainActivity).changeFragment(InicioSesionFragment.newInstance())
        }

        btnCrearCuenta_registro.setOnClickListener(){
            crearNuevaCuenta()
        }
    }

    private fun crearNuevaCuenta() {
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        dbReference = database.reference.child("usuarios")
        progressBar = ProgressBar(requireActivity())

        val txtName = tfNombre_registro.text.toString()
        val txtLastName = tfApellido_reigistro.text.toString()
        val txtEmail = tfCorreo_registro.text.toString()
        val txtPassword = tfContrasenia_registro.text.toString()
        progressBar = registro_progressBar
        if (!TextUtils.isEmpty(txtName) && !TextUtils.isEmpty(txtLastName) && !TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)) {
            progressBar.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(txtEmail, txtPassword)
                .addOnCompleteListener(requireActivity()) { task: Task<AuthResult> ->
                    if (task.isComplete) {
                        val user: FirebaseUser? = auth.currentUser
                        verifyEmail(user)
                        val userBD = dbReference.child(user?.uid.toString())
                        userBD.child("nombre").setValue(txtName)
                        userBD.child("apellido").setValue(txtLastName)
                        action()
                    }
                }
        }
    }

    private fun action(){
        (context as MainActivity).changeFragment(InicioSesionFragment.newInstance())
    }

    private fun verifyEmail(user: FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(requireActivity()) { task: Task<Void> ->
                if (task.isComplete) {
                    Toast.makeText(requireActivity(), "Email enviado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "Error al enviar el correo",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    companion object {
        fun newInstance(): RegistroFragment{
            return RegistroFragment()
        }
    }
}



