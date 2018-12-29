package com.example.alin.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdapterOfRv(private val itemList: ArrayList<ItemOfRv>) : RecyclerView.Adapter<AdapterOfRv.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false), mListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv_title.text = itemList[position].mTitle()
        holder.tv_descr.text = itemList[position].mDescr()
    }

    class ViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

        val tv_title: TextView = view.findViewById(R.id.tv_title)
        val tv_descr: TextView = view.findViewById(R.id.tv_descr)

        init {
            view.setOnClickListener {

                if (adapterPosition != RecyclerView.NO_POSITION)
                    listener.onItemClick(adapterPosition)

            }
        }

    }
}