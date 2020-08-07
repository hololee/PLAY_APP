package com.example.play_app

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog

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

        val info = listlayout.findViewById<ImageButton>(R.id.btn_info)
        info?.setOnClickListener {
            showInfo(nameTextView.text.toString())
        }

        return listlayout
    }

    fun showInfo(name:String){

        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.play_list_check_layout,null)
        val playName :TextView = view.findViewById<TextView>(R.id.title)
        playName.setText(name)
        val textView1: TextView = view.findViewById<TextView>(R.id.place_info)
        var place_current = PlayListActivity::place_current.get(PlayListActivity())
        if(place_current==false) textView1.setText("실내")
        else textView1.setText("실외")

        val textView2: TextView = view.findViewById<TextView>(R.id.cost_info)
        var cost_current = PlayListActivity::cost_current.get(PlayListActivity())
        if(cost_current==false) textView2.setText("무료")
        else textView2.setText("유료")

        val textView3: TextView = view.findViewById<TextView>(R.id.num_info)
        var num_current = PlayListActivity::num_current.get(PlayListActivity())
        if(num_current==false) textView3.setText("혼자")
        else textView3.setText("여럿이")

        val textView4: TextView = view.findViewById<TextView>(R.id.act_info)
        var act_current = PlayListActivity::act_current.get(PlayListActivity())
        if(act_current==false) textView4.setText("활동적")
        else textView4.setText("비활동적")

        val alertDialog = AlertDialog.Builder(mContext).setCancelable(false).create()
        val close_button = view.findViewById<ImageButton>(R.id.close)
        close_button.setOnClickListener {
            alertDialog.cancel()
        }

        alertDialog.setView(view)
        alertDialog.show()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog.window?.setLayout(1000, 1200)

    }

}