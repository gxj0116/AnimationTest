package com.example.animationtest

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val items = listOf<String>(
            "items-1",
            "items-2",
            "items-3",
            "items-4",
            "items-5",
            "items-6",
            "items-7",
            "items-8",
            "items-9",
            "items-10",
            "items-11",
            "items-12"
    )

//    private lateinit var mAdapter: ListViewAdapter
    private var mAdapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mAdapter = ListViewAdapter(this, items)

        listView.adapter = mAdapter

        //Java[Kotlin]代码实现LayoutAnimation
//        var animation = AnimationUtils.loadAnimation(this, R.anim.anim_item);
//
//        var controller = LayoutAnimationController(animation)
//
//        controller.delay = 0.5f
//        controller.order = LayoutAnimationController.ORDER_NORMAL
//
//        listView.layoutAnimation = controller
    }
}

class ListViewAdapter(val context: Context, val items: List<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        return LayoutInflater.from(convertView?.context).inflate(R.layout.item, null)

        val item:String = getItem(position)
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
