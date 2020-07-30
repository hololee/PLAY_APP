package com.example.play_app

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams;
import android.view.Gravity
import android.widget.Button
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_play_list.*
import kotlinx.android.synthetic.main.activity_play_list.view.*
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import org.w3c.dom.Text


class PlayListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_list)

        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = MyCustomAdapter(this)

        val item = arrayOf("1일 클래스","PC방","VR카페","계곡가기","공기놀이","공방","궁 가기","노래방","놀이공원","농구","달리기","당구장","동물원","드라마보기","등산","디스코팡팡 타기","딸기게임","땅따먹기","만화카페","바니바니 게임","바다가기","방탈출카페","밸런스게임","번지점프","베이킹하기","보드게임","볼링장","빙고게임","산책하기","셀카찍기","셀프네일하기","손병호게임","쇼핑","수영","스카이다이빙","스케이트장","스쿠버다이빙","스키장 가기","슬라임카페","식물원","썰매장","쎄쎄쎄","아이엠그라운드 게임","암흑카페","야구","영화","오락실","오렌지게임","오목","요리하기","이미지사진 찍기","인생네컷 찍기","장문복게임","전시회","종이접기","진실게임","쪽팔려게임","축구","카드게임","카페투어","컬러링북","클라이밍","클레오파트라 게임","타로","틀린그림찾기","피크닉","피포페인팅","향수 만들기","홍삼게임","화장품 만들기")



//        val layout = findViewById<ScrollView>(R.id.scrollView)
//
//        val rl : RelativeLayout = RelativeLayout(this)
//        layout.addView(rl)
//
//        var play_list = listOf("1일 클래스","PC방","VR카페","계곡가기","공기놀이","공방","궁 가기","노래방","놀이공원","농구","달리기","당구장","동물원","드라마보기","등산","디스코팡팡 타기","딸기게임","땅따먹기","만화카페","바니바니 게임","바다가기","방탈출카페","밸런스게임","번지점프","베이킹하기","보드게임","볼링장","빙고게임","산책하기","셀카찍기","셀프네일하기","손병호게임","쇼핑","수영","스카이다이빙","스케이트장","스쿠버다이빙","스키장 가기","슬라임카페","식물원","썰매장","쎄쎄쎄","아이엠그라운드 게임","암흑카페","야구","영화","오락실","오렌지게임","오목","요리하기","이미지사진 찍기","인생네컷 찍기","장문복게임","전시회","종이접기","진실게임","쪽팔려게임","축구","카드게임","카페투어","컬러링북","클라이밍","클레오파트라 게임","타로","틀린그림찾기","피크닉","피포페인팅","향수 만들기","홍삼게임","화장품 만들기")
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_play_list)
//        var textView : TextView = TextView(this)
//        for(item in play_list.indices)
//        {
//            textView.text="${play_list[item]}"
//            textView.width = 60
//            textView.setTextColor(Color.BLACK)
//            textView.textSize = 30F
//        }

    }
}

private class MyCustomAdapter(context: Context) : BaseAdapter()
{
    private val mContext: Context

    private val names = arrayListOf<String>(
        "1일 클래스","PC방","VR카페","계곡가기","공기놀이","공방","궁 가기","노래방","놀이공원","농구","달리기","당구장","동물원","드라마보기","등산","디스코팡팡 타기","딸기게임","땅따먹기","만화카페","바니바니 게임","바다가기","방탈출카페","밸런스게임","번지점프","베이킹하기","보드게임","볼링장","빙고게임","산책하기","셀카찍기","셀프네일하기","손병호게임","쇼핑","수영","스카이다이빙","스케이트장","스쿠버다이빙","스키장 가기","슬라임카페","식물원","썰매장","쎄쎄쎄","아이엠그라운드 게임","암흑카페","야구","영화","오락실","오렌지게임","오목","요리하기","이미지사진 찍기","인생네컷 찍기","장문복게임","전시회","종이접기","진실게임","쪽팔려게임","축구","카드게임","카페투어","컬러링북","클라이밍","클레오파트라 게임","타로","틀린그림찾기","피크닉","피포페인팅","향수 만들기","홍삼게임","화장품 만들기"
    )

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return names.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItem(position: Int): Any {
        val selectItem = names[position]
    return selectItem
    }

    override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {

        val layoutInflater = LayoutInflater.from(mContext)
        val listlayout = layoutInflater.inflate(R.layout.listview_layout,viewgroup,false)

        val nameTextView = listlayout.findViewById<TextView>(R.id.list_item)
        nameTextView.text = names[position]
        return listlayout
    }
}