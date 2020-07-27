package com.example.play_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.settings_back_button)
        val appInfoButton = findViewById<ImageButton>(R.id.app_info_button)
        val playListButton = findViewById<ImageButton>(R.id.play_list_button)

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

        playListButton.setOnClickListener {
            val intent = Intent(applicationContext, PlayListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}