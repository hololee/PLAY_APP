package com.example.play_app

import android.content.Context
import android.content.Intent
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
    var indoor:Boolean = false
    var outdoor:Boolean = false
    var free:Boolean = false
    var pay:Boolean = false
    var alone:Boolean = false
    var friend:Boolean = false
    var active:Boolean = false
    var inactive:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val db: PlayDatabase ?= PlayDatabase.getInstance(this)
        val plays = db?.playDao()?.getAll()

        setting.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
        }

        start_button.setOnClickListener{

            val roulette:ImageView = findViewById<ImageView>(R.id.roulette)
            val rotate_animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
            roulette.startAnimation(rotate_animation)
            Handler().postDelayed({
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
                indoorButton -> btn.isSelected = indoor
                outdoorButton -> btn.isSelected = outdoor
                freeButton -> btn.isSelected = free
                payButton -> btn.isSelected = pay
                aloneButton -> btn.isSelected = alone
                friendButton -> btn.isSelected = friend
                activeButton -> btn.isSelected = active
                inactiveButton -> btn.isSelected = inactive
            }
            btn.setOnClickListener{
                if(btn.isSelected==false){
                    btn.isSelected = true
                    when(btn){
                        indoorButton -> indoor = true
                        outdoorButton -> outdoor = true
                        freeButton -> free = true
                        payButton -> pay = true
                        aloneButton -> alone = true
                        friendButton -> friend = true
                        activeButton -> active = true
                        inactiveButton -> inactive = true
                    }
                }else{
                    btn.isSelected = false
                    when(btn){
                        indoorButton -> indoor = false
                        outdoorButton -> outdoor = false
                        freeButton -> free = false
                        payButton -> pay = false
                        aloneButton -> alone = false
                        friendButton -> friend = false
                        activeButton -> active = false
                        inactiveButton -> inactive = false
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