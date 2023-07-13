package com.example.runworkshop.ui.view.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runworkshop.R
import com.example.runworkshop.data.model.UniversidadModel

class UniversidadAdapter(var universidadList: List<UniversidadModel> = emptyList()) :
   RecyclerView.Adapter<UniversidadViewHolder>() {

   fun updateList(universidadList: List<UniversidadModel>){
      this.universidadList = universidadList
      notifyDataSetChanged()
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversidadViewHolder {
      return UniversidadViewHolder(
         LayoutInflater.from(parent.context).inflate(R.layout.item_rvuniversidad, parent, false)
      )
   }

   override fun getItemCount(): Int {
      return universidadList.size
   }

   override fun onBindViewHolder(viewholder: UniversidadViewHolder, position: Int) {
      viewholder.bind(universidadList[position])
   }


}