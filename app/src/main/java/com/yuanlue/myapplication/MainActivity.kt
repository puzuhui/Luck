package com.yuanlue.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

inline fun <reified T:Activity> Activity.startActivity(context: Context){
    startActivity(Intent(context,T::class.java))
}

class MainActivity : AppCompatActivity() {
    private var handler: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("====", "onCreate: " +filesDir.absolutePath)
        textview.setOnClickListener {
            luckview.start(4)
        }

//        recycler_view.adapter = Adapter()
//        handler = Handler(Looper.getMainLooper()) {
//            recycler_view.smoothScrollBy(10, 0)
//            handler?.sendEmptyMessageDelayed(0, 150)
//            true
//        }
//        handler?.sendEmptyMessage(0)
    }

    var actions: (() -> Int)? = null
    fun setAction(action: () -> Int) {
        actions = action
    }

    class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {
        var mData = mutableListOf<String>("3216514", "你好啊", "测试")

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.textView).text =
                mData[position % mData.size]
        }

        override fun getItemCount(): Int {
            return 1000
        }

    }
}