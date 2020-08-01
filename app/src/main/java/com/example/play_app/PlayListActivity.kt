package com.example.play_app

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.*
import kotlinx.android.synthetic.main.activity_play_list.*

var place_current = 0
var cost_current = 0
var num_current = 0
var act_current = 0

class PlayListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list)
        play_list_back_button.setOnClickListener{
            finish()
        }

        val listView = findViewById<ListView>(R.id.listView)
        val item = arrayOf<String>(
            "1일 클래스", "PC방", "VR카페", "계곡가기", "공기놀이", "공방", "궁 가기", "노래방", "놀이공원", "농구", "달리기", "당구장", "동물원", "드라마보기",
            "등산", "디스코팡팡 타기", "딸기게임", "땅따먹기", "만화카페", "바니바니 게임", "바다가기", "방탈출카페", "밸런스게임", "번지점프", "베이킹하기", "보드게임",
            "볼링장", "빙고게임", "산책하기", "셀카찍기", "셀프네일하기", "손병호게임", "쇼핑", "수영", "스카이다이빙", "스케이트장", "스쿠버다이빙", "스키장 가기",
            "슬라임카페", "식물원", "썰매장", "쎄쎄쎄", "아이엠그라운드 게임", "암흑카페", "야구", "영화", "오락실", "오렌지게임", "오목", "요리하기", "이미지사진 찍기",
            "인생네컷 찍기", "장문복게임", "전시회", "종이접기", "진실게임", "쪽팔려게임", "축구", "카드게임", "카페투어", "컬러링북", "클라이밍", "클레오파트라 게임",
            "타로", "틀린그림찾기", "피크닉", "피포페인팅", "향수 만들기", "홍삼게임", "화장품 만들기"
        )
        listView.adapter = MyCustomAdapter(this, item)

        val info = findViewById<ImageButton>(R.id.info_1)
        val plus = findViewById<ImageButton>(R.id.list_add_btn)
        info.setOnClickListener {
            showInfo()
        }
        plus.setOnClickListener {
            showPlus()
        }
    }



    fun showPlus(){
        val inflater = getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.add_popup_layout,null)
        val place_btn: Button = view.findViewById<Button>(R.id.place_button)
        place_btn.setOnClickListener(View.OnClickListener() {
            fun onClick(textView: TextView) {
                if (place_current == 0) {
                    place_btn.setText("실내")
                    place_current = 1
                } else {
                    place_btn.setText("실외")
                    place_current = 0
                }
            }
        }
        )
        val cost_btn: Button = view.findViewById< Button >(R.id.cost_button)
        cost_btn.setOnClickListener(View.OnClickListener() {
            fun onClick(textView: TextView) {
                if (cost_current == 0) {
                    cost_btn.setText("유료")
                    cost_current = 1
                } else {
                    cost_btn.setText("무료")
                    cost_current = 0
                }
            }
        }
        )
        val num_btn: Button = view.findViewById<Button>(R.id.num_button)
        num_btn.setOnClickListener(View.OnClickListener() {
            fun onClick(textView: TextView) {
                if (num_current == 0) {
                    num_btn.setText("혼자")
                    num_current = 1
                } else {
                    num_btn.setText("여러명")
                    num_current = 0
                }
            }
        }
        )
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
        }
        )

        val alertDialog =
            AlertDialog.Builder(this).setCancelable(false).create()
        val close_button = view.findViewById<ImageButton>(R.id.close)
        close_button.setOnClickListener {
            alertDialog.cancel()
        }
        val save = view.findViewById<Button>(R.id.save_button)
        save.setOnClickListener {
            alertDialog.cancel()//저장안되고 일단 닫기
        }
        alertDialog.setView(view)
        alertDialog.show()
        alertDialog.window?.setLayout(1000, 1500)
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    }

    fun showInfo(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.play_list_check_layout,null)

        val textView1: TextView = view.findViewById<TextView>(R.id.place_info)
        if(place_current==0) textView1.text = "실내"
        else textView1.text = "실외"

        val textView2: TextView = view.findViewById<TextView>(R.id.cost_info)
        if(cost_current==0) textView2.text = "유료"
        else textView2.text = "무료"

        val textView3: TextView = view.findViewById<TextView>(R.id.num_info)
        if(num_current==0) textView3.text = "혼자"
        else textView3.text = "여럿이서"

        val textView4: TextView = view.findViewById<TextView>(R.id.act_info)
        if(act_current==0) textView4.text = "활동적"
        else textView4.text = "비활동적"

        val alertDialog = AlertDialog.Builder(this).setCancelable(false).create()
        val close_button = view.findViewById<ImageButton>(R.id.close)
        close_button.setOnClickListener {
            alertDialog.cancel()
        }
        alertDialog.setView(view)
        alertDialog.show()
        val layout = alertDialog.window?.setLayout(1000, 850)
    }

}



