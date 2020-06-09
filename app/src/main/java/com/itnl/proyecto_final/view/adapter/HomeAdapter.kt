package com.itnl.proyecto_final.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itnl.proyecto_final.modelo.Tarea
import com.itnl.proyecto_final.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeAdapter(val homeListener: HomeListener) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var listTareas = ArrayList<Tarea>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false))

    override fun getItemCount() = listTareas.size

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val tarea = listTareas[position] as Tarea

        holder.tvNombreDeTarea.text = tarea.nombre
        holder.tvDescripcionDeTarea.text = tarea.descripcion

        val simpleDateformat = SimpleDateFormat("EEE, MMM d,''yy")

        val cal = Calendar.getInstance()
        cal.time = tarea.fechaDeEntrega
        val monthFormat = simpleDateformat.format(tarea.fechaDeEntrega)
        //val hourFormat = simpleDateformat.format(conference.datetime)

        //holder.tvConferenceHour.text = hourFormat
        holder.tvFechaDeEntrega.text = simpleDateformat.format(tarea.fechaDeEntrega).toUpperCase()

        holder.itemView.setOnClickListener {
            homeListener.onTareaClicked(tarea, position)
        }
    }

    fun updateData(data: List<Tarea>) {
        listTareas.clear()
        listTareas.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreDeTarea = itemView.findViewById<TextView>(R.id.tvNombreDeTarea)
        val tvFechaDeEntrega = itemView.findViewById<TextView>(R.id.tvFechaDeEntrega)
        val tvDescripcionDeTarea = itemView.findViewById<TextView>(R.id.tvDescripcionDeTarea)
    }
}