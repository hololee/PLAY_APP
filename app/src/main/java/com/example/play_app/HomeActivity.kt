package com.example.play_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.filter_layout.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setting.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
            finish()
        }

        start_button.setOnClickListener{

            val roulette:ImageView = findViewById<ImageView>(R.id.roulette)
            val rotate_animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
            roulette.startAnimation(rotate_animation)
            Handler().postDelayed({
                showResult()
            },2500)

        }

        filter_button.setOnClickListener {
            showFilter()
        }

    }
    fun showResult(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout,null)
        val textView: TextView = view.findViewById<TextView>(R.id.result)
        textView.text = "결과"
        val alertDialog = AlertDialog.Builder(this).setCancelable(false).create()
        val close_button = view.findViewById<ImageButton>(R.id.close)
        close_button.setOnClickListener {
            alertDialog.cancel()
        }
        alertDialog.setView(view)
        alertDialog.show()
        alertDialog.window?.setLayout(1000,750)
    }

    fun showFilter(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.filter_layout,null)
        val alertDialog = AlertDialog.Builder(this).create()
        val finish_select_button = view.findViewById<Button>(R.id.finish_select_button)
        finish_select_button.setOnClickListener{
            alertDialog.cancel()
        }
        fun buttonSelected(id:Int){
            val btn = view.findViewById<Button>(id)
            btn.setOnClickListener{
                if(btn.isSelected==false){
                    btn.isSelected = true
                }else{
                    btn.isSelected = false
                }
            }

        }
        buttonSelected(R.id.indoor_button)
        buttonSelected(R.id.outdoor_button)
        buttonSelected(R.id.free_button)
        buttonSelected(R.id.pay_button)
        buttonSelected(R.id.alone_button)
        buttonSelected(R.id.friend_button)
        buttonSelected(R.id.active_button)
        buttonSelected(R.id.inactive_button)
        alertDialog.setView(view)
        alertDialog.show()
    }

}