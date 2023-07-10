package com.example.runworkshop.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.databinding.ItemRvinstitutoBinding

class InstitutoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRvinstitutoBinding.bind(view)
    fun bind(institutoModel: InstitutoModel) {
        binding.tvInstitutos.text = institutoModel.instituto
        binding.tvDireccion.text = institutoModel.direccion
        binding.tvTaller.text = institutoModel.taller
        binding.tvDescripcion.text = institutoModel.descripcion
        binding.tvCosto.text = institutoModel.costo
        binding.tvFecha.text = institutoModel.fecha
        binding.tvHora.text = institutoModel.hora
    }
}