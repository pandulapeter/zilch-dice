package com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid

import android.app.Application
import androidx.annotation.StyleRes

interface DebugMenuContract {

    fun initialize(
        application: Application,
        applicationTitle: String,
        @StyleRes themeResourceId: Int
    ) = Unit
}