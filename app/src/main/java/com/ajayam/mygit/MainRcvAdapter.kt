package com.ajayam.mygit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRcvAdapter(val requiredContext : Context, private  val listDetails : ArrayList<GitLIstClass>) : RecyclerView.Adapter<MainRcvAdapter.MainViewHolder>() {

    class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.rcyclr_name)
        val desc : TextView = itemView.findViewById(R.id.rcyclr_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.added_list_layout, parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDetails.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.name.text = listDetails[position].gitName
        holder.desc.text = listDetails[position].gitDesc
    }


}