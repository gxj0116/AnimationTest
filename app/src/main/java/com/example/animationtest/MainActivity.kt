package com.example.animationtest

import android.content.Context
import android.content.Intent
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
import com.example.animationtest.adapter.ListViewAdapter

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

        jump.setOnClickListener {
            val intent = Intent(MainActivity@this, SecondActivity::class.java)
            startActivity(intent)
            /**
             * 参数说明:
             *  enterAnim: Activity被打开时, 所需的动画资源id;
             *  exitAnim: Activity被暂停时, 所需的动画资源id;
             */
            overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim)
        }
    }
}


