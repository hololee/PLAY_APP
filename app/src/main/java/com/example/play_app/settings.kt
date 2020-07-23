package com.example.play_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_settings.*

class settings : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val back_button = findViewById<ImageButton>(R.id.back_button)
        // 빨간줄 뜨면 alt + enter 눌러서 import 시키면 됩니다. : import error 의 경우.

        val app_info_button = findViewById<ImageButton>(R.id.back_button)

        back_button.setOnClickListener {
            val intent = Intent(applicationContext, home::class.java)
            startActivity(intent)
            finish()
        }

        app_info_button.setOnClickListener {
            val intent = Intent(applicationContext, app_info::class.java)
            startActivity(intent)
            finish()
        }
    }
}