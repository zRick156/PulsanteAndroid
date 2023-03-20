package com.example.pulsante

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pulsante.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val btnRickRoll = findViewById<Button>(id.btnRickRoll)
        val btnBho = findViewById<Button>(id.btnBho)
        val sound1 : MediaPlayer = MediaPlayer.create(this, raw.epic)

        btnRickRoll.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uHgt8giw1LY"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)

        }
        btnBho.setOnClickListener(){
        sound1.start()
        }
    }
}