package com.example.alin.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemList = ArrayList<ItemOfRv>()
    private fun setItemList() {

        for (i in 1 until 10)
            itemList.add(ItemOfRv("Title $i", "description $i"))
    }

    private fun setRecyclerView() {

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterOfRv(itemList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setItemList()
        setRecyclerView()
    }
}
