package com.example.animationtest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.animationtest.R

class ListViewAdapter(val context: Context, val items: List<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        return LayoutInflater.from(convertView?.context).inflate(R.layout.item, null)

        val item: String = getItem(position)
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        val itemName = view.findViewById<TextView>(R.id.item_name)
        itemName.text = item
        return view
    }

    override fun getItem(position: Int): String {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }


}