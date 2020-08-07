package com.example.play_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Button

public class MyCustomAdapter(context: Context,item : ArrayList<String>) : BaseAdapter() {
    private val mContext: Context
    private val mitem = item

    init {
        mContext = context
    }

    override fun getCount() = mitem.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItem(position: Int) = mitem[position]

    override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {

        val layoutInflater = LayoutInflater.from(mContext)
        val listlayout = layoutInflater.inflate(R.layout.listview_layout, viewgroup, false)

        val nameTextView = listlayout.findViewById<TextView>(R.id.list_item)
        nameTextView.text = mitem[position]

        return listlayout
    }

}