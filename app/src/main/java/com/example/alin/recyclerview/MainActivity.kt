package com.example.alin.recyclerview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterOfRv.OnItemClickListener {

    private val itemList = ArrayList<ItemOfRv>()
    private lateinit var mAdapter: AdapterOfRv

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setItemList()
        setRecyclerView()

        btInsert.setOnClickListener {
            insert(Integer.parseInt(etIdToEdit.text.toString()))
        }

        btDelete.setOnClickListener {
            delete(Integer.parseInt(etIdToEdit.text.toString()))
        }
    }

    override fun onItemClick(position: Int) {
        showMessage(this, position.toString(), false)
    }

    private fun insert(position: Int) {

        if (position in 0 until itemList.size) {
            itemList.add(position, ItemOfRv("new title", "new descr"))
            recyclerView.adapter!!.notifyItemInserted(position)

        } else showMessage(this, "Index out of bounds!", false)
    }

    private fun delete(position: Int) {

        if (position in 0 until itemList.size) {
            itemList.removeAt(position)
            recyclerView.adapter!!.notifyItemRemoved(position)

        } else showMessage(this, "Index out of bounds!", false)

    }


    private fun setItemList() {

        for (i in 1 until 10)
            itemList.add(ItemOfRv("Title $i", "description $i"))
    }

    private fun setRecyclerView() {

        mAdapter = AdapterOfRv(itemList)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

        mAdapter.setOnItemClickListener(object : AdapterOfRv.OnItemClickListener {
            override fun onItemClick(position: Int) {

                itemList[position].updateTitle("New one")
                mAdapter.notifyItemChanged(position)

            }
        })

    }

    fun showMessage(context: Context, message: String, isLong: Boolean) {
        Toast.makeText(context, message, if (isLong)
            Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
    }

}
