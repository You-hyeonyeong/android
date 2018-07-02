package org.weatherook.weatherook.ui.fragment

import android.os.Bundle
import android.preference.PreferenceFragment

import org.weatherook.weatherook.R

class SettingsFragment : PreferenceFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.settings)
    }
}
