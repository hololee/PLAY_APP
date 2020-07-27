package com.example.play_app


import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.play_list_check_layout.view.*
import kotlinx.android.synthetic.main.play_list_check_layout.view.place_info as place_info1

class PlayListActivity() : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list)
        val info = findViewById<TextView>(R.id.info_1)
        val plus = findViewById<TextView>(R.id.list_add_btn)
        info.setOnClickListener {
            showInfo()
        }
        plus.setOnClickListener {
            showPlus()
        }
    }
        //info 팝업 띄우기 -> 텍스트 설정조건에 맞게 바뀌도록 조건문 설정해야 함 (static 변수 사용 필요)
        fun showInfo(){
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.play_list_check_layout,null)

            val textView1: TextView = view.findViewById<TextView>(R.id.place_info)
            textView1.text = "실내"
            val textView2: TextView = view.findViewById<TextView>(R.id.cost_info)
            textView2.text = "유료"
            val textView3: TextView = view.findViewById<TextView>(R.id.num_info)
            textView3.text = "혼자"
            val textView4: TextView = view.findViewById<TextView>(R.id.act_info)
            textView4.text = "활동적"

            val alertDialog = AlertDialog.Builder(this).setCancelable(false).create()
            val close_button = view.findViewById<ImageButton>(R.id.close)
            close_button.setOnClickListener {
                alertDialog.cancel()
            }
            alertDialog.setView(view)
            alertDialog.show()
            val layout = alertDialog.window?.setLayout(1000, 850)
        }


        fun showPlus(){
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.play_list_check_layout,null)
            var place_current = 0
            var cost_current = 0
            var num_current = 0
            var act_current = 0
            val place_btn: Button = view.findViewById<Button>(R.id.place_button)
            place_btn.setOnClickListener( View.OnClickListener() {
                fun onClick(textView: TextView) {
                    if (place_current==0) {
                        place_btn.setText("실내")
                        place_current = 1}
                    else{
                        place_btn.setText("실외")
                        place_current = 0
                    }
            val cost_btn: Button = view.findViewById<Button>(R.id.cost_button)
            cost_btn.setOnClickListener( View.OnClickListener() {
                fun onClick(textView: TextView) {
                    if (cost_current==0) {
                       cost_btn.setText("유료")
                       cost_current = 1}
                    else{
                        cost_btn.setText("무료")
                        cost_current = 0
                    }
                }
             val num_btn: Button = view.findViewById<Button>(R.id.num_button)
             num_btn.setOnClickListener( View.OnClickListener() {
                 fun onClick(textView: TextView) {
                     if (num_current == 0) {
                         num_btn.setText("혼자")
                         num_current = 1
                     } else {
                         num_btn.setText("여러명")
                         num_current = 0
                     }
                 }
             val act_btn: Button = view.findViewById<Button>(R.id.act_button)
             act_btn.setOnClickListener( View.OnClickListener() {
                 fun onClick(textView: TextView) {
                     if (act_current == 0) {
                         act_btn.setText("활동적")
                         act_current = 1
                     } else {
                         act_btn.setText("비활동적")
                         act_current = 0
                     }
                 }

                 val alertDialog =
                     AlertDialog.Builder(this).setCancelable(false).create()
                 val close_button = view.findViewById<ImageButton>(R.id.close)
                 close_button.setOnClickListener {
                     alertDialog.cancel()
                 }
                 val save = view.findViewById<ImageButton>(R.id.save_button)
                 save.setOnClickListener {
                     alertDialog.cancel()//저장안되고 일단 닫기
                 }
                 alertDialog.setView(view)
                 alertDialog.show()
                 val layout = alertDialog.window?.setLayout(1000, 850)
             }



    }





