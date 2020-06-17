package com.derayanbimaa.darkmode

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate


/**
 * @author Derayan Bima Alamsyah (derayan.bima@dana.id)
 * @version Settings, v 0.1 18/06/20 01.33 by Derayan Bima Alamsyah
 */
object DefaultSettings {
    /**
     * The night mode.
     */
    const val NIGHT_MODE = "night_mode"

    /**
     * Night mode which uses the recommended default option.
     */
    val MODE_NIGHT_DEFAULT = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    } else {
        AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
    }
}