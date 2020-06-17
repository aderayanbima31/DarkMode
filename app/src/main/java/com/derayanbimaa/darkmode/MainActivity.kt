package com.derayanbimaa.darkmode

import android.os.Bundle
import androidx.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(ActivityCompat.requireViewById(this, R.id.toolbar))
        initFab()
    }

    /**
     * Initializes the FAB.
     */
    private fun initFab() {
        fab = ActivityCompat.requireViewById(this, R.id.fab)
        val mode = AppCompatDelegate.getDefaultNightMode()
        initFab(mode)
    }

    /**
     * Initializes the FAB with the given night [mode].
     */
    private fun initFab(mode: Int) {
        when (mode) {
            AppCompatDelegate.MODE_NIGHT_NO -> {
                fab.setImageResource(R.drawable.ic_mode_night_no_black_24dp)
                fab.setOnClickListener { setNightMode(AppCompatDelegate.MODE_NIGHT_YES) }
            }
            AppCompatDelegate.MODE_NIGHT_YES -> {
                fab.setImageResource(R.drawable.ic_mode_night_yes_black_24dp)
                fab.setOnClickListener { setNightMode(DefaultSettings.MODE_NIGHT_DEFAULT) }
            }
            else -> {
                fab.setImageResource(R.drawable.ic_mode_night_default_black_24dp)
                fab.setOnClickListener { setNightMode(AppCompatDelegate.MODE_NIGHT_NO) }
            }
        }
    }

    /**
     * Sets the default night [mode].
     */
    private fun setNightMode(mode: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.edit().putInt(DefaultSettings.NIGHT_MODE, mode).apply()
        AppCompatDelegate.setDefaultNightMode(mode)
        initFab(mode)
    }

}