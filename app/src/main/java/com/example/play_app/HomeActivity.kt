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

        setting.setOnClickListener {
            val intent = Intent(this,SettingsActivity::class.java)
            startActivity(intent)
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
        val db: PlayDatabase ?= PlayDatabase.getInstance(this)
        val plays = arrayListOf<String>(
            "1일 클래스", "PC방", "VR카페", "계곡가기", "공기놀이", "공방", "궁 가기", "노래방", "놀이공원", "농구", "달리기", "당구장", "동물원", "드라마보기",
            "등산", "디스코팡팡 타기", "딸기게임", "땅따먹기", "만화카페", "바니바니 게임", "바다가기", "방탈출카페", "밸런스게임", "번지점프", "베이킹하기", "보드게임",
            "볼링장", "빙고게임", "산책하기", "셀카찍기", "셀프네일하기", "손병호게임", "쇼핑", "수영", "스카이다이빙", "스케이트장", "스쿠버다이빙", "스키장 가기",
            "슬라임카페", "식물원", "썰매장", "쎄쎄쎄", "아이엠그라운드 게임", "암흑카페", "야구", "영화", "오락실", "오렌지게임", "오목", "요리하기", "이미지사진 찍기",
            "인생네컷 찍기", "장문복게임", "전시회", "종이접기", "진실게임", "쪽팔려게임", "축구", "카드게임", "카페투어", "컬러링북", "클라이밍", "클레오파트라 게임",
            "타로", "틀린그림찾기", "피크닉", "피포페인팅", "향수 만들기", "홍삼게임", "화장품 만들기"
        ) //db!!.playDao().getAll()
        val num = Random().nextInt(plays.size)
        val result = plays.get(num)
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