package com.example.play_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        // 빨간줄 뜨면 alt + enter 눌러서 import 시키면 됩니다. : import error 의 경우.

        val appInfoButton = findViewById<ImageButton>(R.id.app_info_button)

        backButton.setOnClickListener {
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        appInfoButton.setOnClickListener {
            val intent = Intent(applicationContext, AppInfoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}