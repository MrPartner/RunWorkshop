package com.example.runworkshop.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.R
import com.example.runworkshop.data.model.InstitutoModel


class InstitutoAdapter(var institutoList: List<InstitutoModel> = emptyList()) :
    RecyclerView.Adapter<InstitutoViewHolder>() {

    fun updateList(institutoList: List<InstitutoModel>){
        this.institutoList = institutoList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstitutoViewHolder {
        return InstitutoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rvinstituto, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return institutoList.size
    }

    override fun onBindViewHolder(viewholder: InstitutoViewHolder, position: Int) {
        viewholder.bind(institutoList[position])
    }

}

