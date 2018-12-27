package com.example.alin.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdapterOfRv(private val itemList: ArrayList<ItemOfRv>) : RecyclerView.Adapter<AdapterOfRv.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_title.text = itemList[position].mTitle()
        holder.tv_descr.text = itemList[position].mDescr()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_title: TextView = view.findViewById(R.id.tv_title)
        val tv_descr: TextView = view.findViewById(R.id.tv_descr)
    }

}