package com.example.pulsante

import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.pulsante.R.*

class MainActivity : AppCompatActivity() {
    private var cameraManager: CameraManager? = null
    private var getCameraID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)


        val toggleFlashLightOnOff: CompoundButton = findViewById(id.swBackground)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            getCameraID = cameraManager!!.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        val btnRickRoll = findViewById<Button>(id.btnRickRoll)
        val btnBho = findViewById<Button>(id.btnBho)
        val sound1: MediaPlayer = MediaPlayer.create(this, raw.epic)


        toggleFlashLightOnOff.setOnCheckedChangeListener { compoundButton, onSwitch ->
            if (onSwitch) {
                try {
                    cameraManager!!.setTorchMode(getCameraID!!, true)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } catch (e: CameraAccessException) {
                    e.printStackTrace()

                }
            } else {
                try {
                    cameraManager!!.setTorchMode(getCameraID!!, false)
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            }
        }

        btnRickRoll.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=uHgt8giw1LY"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)

        }

        btnBho.setOnClickListener {
            sound1.start()
        }


    }
}
