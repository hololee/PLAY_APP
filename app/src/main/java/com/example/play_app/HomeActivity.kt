package com.example.play_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import com.example.play_app.db.PlayDatabase
import com.example.play_app.db.entity.Play
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.filter_layout.*
import java.util.*

class HomeActivity : AppCompatActivity() {
    companion object
    {
        lateinit var pref: PreferenceUtil
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        pref = PreferenceUtil(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val db: PlayDatabase ?= PlayDatabase.getInstance(this)
        var plays:List<Play>?

        setting.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }

        start_button.setOnClickListener{

            val roulette:ImageView = findViewById<ImageView>(R.id.roulette)
            val rotate_animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
            roulette.startAnimation(rotate_animation)
            Handler().postDelayed({
                plays = db?.playDao()?.getAll()
                showResult(plays)
            },2500)

        }

        filter_button.setOnClickListener {
            showFilter()
        }

    }

    fun showResult(plays:List<Play>?){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.popup_layout,null)
        val textView: TextView = view.findViewById<TextView>(R.id.result)
        val num = Random().nextInt(plays!!.size)
        val result = plays?.get(num).play_name
        textView.text = result.toString()
        val alertDialog = AlertDialog.Builder(this).setCancelable(false).create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val close_button = view.findViewById<ImageButton>(R.id.close)
        close_button.setOnClickListener {
            alertDialog.cancel()
        }
        alertDialog.setView(view)
        alertDialog.show()
        alertDialog.window?.setLayout(1000,800)
    }

    fun showFilter(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.filter_layout,null)
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val finish_select_button = view.findViewById<Button>(R.id.finish_select_button)
        finish_select_button.setOnClickListener{
            alertDialog.cancel()
        }

        fun buttonSelected(id:Int){
            val btn = view.findViewById<Button>(id)
            val indoorButton = view.findViewById<Button>(R.id.indoor_button)
            val outdoorButton = view.findViewById<Button>(R.id.outdoor_button)
            val freeButton = view.findViewById<Button>(R.id.free_button)
            val payButton = view.findViewById<Button>(R.id.pay_button)
            val aloneButton = view.findViewById<Button>(R.id.alone_button)
            val friendButton = view.findViewById<Button>(R.id.friend_button)
            val activeButton = view.findViewById<Button>(R.id.active_button)
            val inactiveButton = view.findViewById<Button>(R.id.inactive_button)

            when(btn){
                indoorButton -> btn.isSelected = pref.getBoolean("indoor",false)
                outdoorButton -> btn.isSelected = pref.getBoolean("outdoor",false)
                freeButton -> btn.isSelected = pref.getBoolean("free",false)
                payButton -> btn.isSelected = pref.getBoolean("pay",false)
                aloneButton -> btn.isSelected = pref.getBoolean("alone",false)
                friendButton -> btn.isSelected = pref.getBoolean("friend",false)
                activeButton -> btn.isSelected = pref.getBoolean("active",false)
                inactiveButton -> btn.isSelected = pref.getBoolean("inactive",false)
            }
            btn.setOnClickListener{
                if(btn.isSelected==false){
                    btn.isSelected = true
                    when(btn){
                        indoorButton -> pref.setBoolean("indoor",this,true)
                        outdoorButton -> pref.setBoolean("outdoor",this,true)
                        freeButton -> pref.setBoolean("free",this,true)
                        payButton -> pref.setBoolean("pay",this,true)
                        aloneButton -> pref.setBoolean("alone",this,true)
                        friendButton -> pref.setBoolean("friend",this,true)
                        activeButton -> pref.setBoolean("active",this,true)
                        inactiveButton -> pref.setBoolean("inactive",this,true)
                    }
                }else{
                    btn.isSelected = false
                    when(btn){
                        indoorButton -> pref.setBoolean("indoor",this,false)
                        outdoorButton -> pref.setBoolean("outdoor",this,false)
                        freeButton -> pref.setBoolean("free",this,false)
                        payButton -> pref.setBoolean("pay",this,false)
                        aloneButton -> pref.setBoolean("alone",this,false)
                        friendButton -> pref.setBoolean("friend",this,false)
                        activeButton -> pref.setBoolean("active",this,false)
                        inactiveButton -> pref.setBoolean("inactive",this,false)
                    }
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