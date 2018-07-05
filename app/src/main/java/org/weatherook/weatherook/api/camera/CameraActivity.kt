package org.weatherook.weatherook.api.camera

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.weatherook.weatherook.R

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
                .replace(R.id.container, Camera2BasicFragment.newInstance())
                .commit()
    }
}