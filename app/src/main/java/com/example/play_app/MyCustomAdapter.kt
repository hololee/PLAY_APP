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
import com.example.play_app.db.entity.Play
public class MyCustomAdapter(context: Context,item : ArrayList<Play>?) : BaseAdapter() {
    private val mContext: Context
    private val mitem = item

    init {
        mContext = context
    }

    override fun getCount() = mitem!!.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItem(position: Int) = mitem?.get(position)

    override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {


        val layoutInflater = LayoutInflater.from(mContext)
        val listlayout = layoutInflater.inflate(R.layout.listview_layout, viewgroup, false)

        val nameTextView = listlayout.findViewById<TextView>(R.id.list_item)
        nameTextView.text = mitem?.get(position)?.play_name


        val info = listlayout.findViewById<ImageButton>(R.id.btn_info)
        info?.setOnClickListener {
            showInfo(getItem(position))
        }

        return listlayout
    }

    fun showInfo(item:Play?){

        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.play_list_check_layout,null)
        val playName :TextView = view.findViewById<TextView>(R.id.title)
        playName.setText(item?.play_name)
        val textView1: TextView = view.findViewById<TextView>(R.id.place_info)
        if(item?.place=="실내") textView1.setText("실내")
        else textView1.setText("실외")

        val textView2: TextView = view.findViewById<TextView>(R.id.cost_info)
        if(item?.cost=="무료") textView2.setText("무료")
        else textView2.setText("유료")

        val textView3: TextView = view.findViewById<TextView>(R.id.num_info)
        if(item?.num=="혼자가능") textView3.setText("혼자가능")
        else textView3.setText("친구필요")

        val textView4: TextView = view.findViewById<TextView>(R.id.act_info)
        if(item?.act=="활동적") textView4.setText("활동적")
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