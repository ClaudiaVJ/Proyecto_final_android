package com.itnl.proyecto_final.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.firebase.firestore.FirebaseFirestore

import com.itnl.proyecto_final.R
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.modelo.Usuario
import com.itnl.proyecto_final.view.adapter.HomeAdapter
import com.itnl.proyecto_final.view.adapter.HomeListener
import com.itnl.proyecto_final.viewmodel.TareaViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_tarea.*
import kotlinx.android.synthetic.main.item_tarea.*
import org.jetbrains.anko.support.v4.alert

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeListener {

    var correoDeUsuario: String? = ""
    var datos = kotlin.collections.ArrayList<String>()

   private lateinit var homeAdapter: HomeAdapter
    private lateinit var viewModel: TareaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
        correoDeUsuario = arguments?.getString("correo")
        datos = arguments?.getStringArrayList("usuario") as ArrayList<String>
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTareas(correoDeUsuario)
        /*viewModel = ViewModelProviders.of(this).get(TareaViewModel::class.java)
        viewModel.refresh()

        homeAdapter = HomeAdapter(this)

        rvTareas.apply {
            //LayoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = homeAdapter
        }
        observeViewModel()*/
    }

    fun getTareas(correo: String?){
        val db = FirebaseFirestore.getInstance()
        var holder: HomeFragment.ViewHolder
        val tareas = db.collection("tareas").whereEqualTo("correo", correo)
        tareas.get().addOnSuccessListener { result ->
            if(result != null){
                for(document in result){
                }
            }
        }
    }

    fun observeViewModel(){
        viewModel.listTarea.observe(this, Observer<List<Tarea>>{
            tarea ->
            homeAdapter.updateData(tarea)
        })

        viewModel.isLoading.observe(this, Observer<Boolean> {
            if(it != null)
                rlBase.visibility = View.INVISIBLE
        })
    }

    override fun onTareaClicked(tarea: Tarea, position: Int) {
        val bundle = bundleOf("tarea" to tarea)
        findNavController().navigate(R.id.tareaDetailDF, bundle)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreDeTarea = itemView.findViewById<TextView>(R.id.tvNombreDeTarea)
        val tvFechaDeEntrega = itemView.findViewById<TextView>(R.id.tvFechaDeEntrega)
        val tvDescripcionDeTarea = itemView.findViewById<TextView>(R.id.tvDescripcionDeTarea)
    }

}