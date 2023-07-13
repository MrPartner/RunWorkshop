package com.example.runworkshop.ui.view.recyclerviews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.data.model.ConsultoraModel
import com.example.runworkshop.databinding.ItemRvconsultoraBinding


class ConsultoraViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRvconsultoraBinding.bind(view)
    fun bind(consultoraModel: ConsultoraModel) {
        binding.tvConsultoras.text = consultoraModel.consultora
        binding.tvDireccion.text = consultoraModel.direccion
        binding.tvTaller.text = consultoraModel.taller
        binding.tvDescripcion.text = consultoraModel.descripcion
        binding.tvCosto.text = consultoraModel.costo
        binding.tvFecha.text = consultoraModel.fecha
        binding.tvHora.text = consultoraModel.hora
    }
}