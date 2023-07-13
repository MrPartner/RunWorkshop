package com.example.runworkshop.ui.view.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.R
import com.example.runworkshop.data.model.ConsultoraModel

class ConsultoraAdapter(var consultoraList: List<ConsultoraModel> = emptyList()) :
    RecyclerView.Adapter<ConsultoraViewHolder>() {

    fun updateList(consultoraList: List<ConsultoraModel>){
        this.consultoraList = consultoraList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultoraViewHolder {
        return ConsultoraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rvconsultora, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return consultoraList.size
    }

    override fun onBindViewHolder(viewholder: ConsultoraViewHolder, position: Int) {
        viewholder.bind(consultoraList[position])
    }

}