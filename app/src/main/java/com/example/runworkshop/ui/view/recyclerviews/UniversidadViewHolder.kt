package com.example.runworkshop.ui.view.recyclerviews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.data.model.UniversidadModel
import com.example.runworkshop.databinding.ItemRvuniversidadBinding

class UniversidadViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRvuniversidadBinding.bind(view)

    fun bind(universidadModel: UniversidadModel) {
        binding.tvUniversidades.text = universidadModel.universidad
        binding.tvDireccion.text = universidadModel.direccion
        binding.tvAudiencia.text = universidadModel.audiencia
        binding.tvTaller.text = universidadModel.taller
        binding.tvDescripcion.text = universidadModel.descripcion
        binding.tvCosto.text = universidadModel.costo
        binding.tvFecha.text = universidadModel.fecha
        binding.tvHora.text = universidadModel.hora
    }
}