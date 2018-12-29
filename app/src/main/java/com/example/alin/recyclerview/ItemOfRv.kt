package com.example.alin.recyclerview

class ItemOfRv(
    private var mTitle: String,
    private val mDescr: String) {

    fun mTitle(): String = mTitle
    fun mDescr(): String = mDescr

    fun updateTitle(newTitle: String) {
        mTitle = newTitle
    }
}