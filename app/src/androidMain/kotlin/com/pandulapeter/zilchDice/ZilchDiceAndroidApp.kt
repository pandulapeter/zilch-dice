package com.pandulapeter.zilchDice

import android.app.Application
import com.pandulapeter.zilchDice.common.ServiceLocator
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.DebugMenu
import org.koin.android.ext.koin.androidContext

class ZilchDiceAndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDebugMenu()
        initializeServiceLocator()
    }

    private fun initializeDebugMenu() = DebugMenu.initialize(
        application = this,
        applicationTitle = getString(R.string.zilch_dice),
        themeResourceId = R.style.ZilchDice
    )

    private fun initializeServiceLocator() = ServiceLocator.initializeModules {
        androidContext(this@ZilchDiceAndroidApp)
    }
}