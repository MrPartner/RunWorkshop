package com.example.runworkshop.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.databinding.ItemRvinstitutoBinding

class InstitutoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRvinstitutoBinding.bind(view)
    fun bind(institutoModel: InstitutoModel) {
        binding.tvInstitutos.text = institutoModel.instituto
    }
}