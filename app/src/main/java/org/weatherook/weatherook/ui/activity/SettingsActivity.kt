package org.weatherook.weatherook.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.weatherook.weatherook.R
import org.weatherook.weatherook.ui.fragment.SettingsFragment



class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        fragmentManager.beginTransaction()
                .replace(R.id.settings_container, SettingsFragment())
                .commit()
    }
}