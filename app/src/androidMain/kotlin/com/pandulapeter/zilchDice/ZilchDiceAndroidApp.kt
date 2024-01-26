package com.pandulapeter.zilchDice

import android.app.Application
import com.pandulapeter.zilchDice.common.ServiceLocator
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.DebugMenu
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext

class ZilchDiceAndroidApp : Application() {

    private val resourceProvider by inject<ResourceProvider>()

    override fun onCreate() {
        super.onCreate()
        initializeServiceLocator()
        initializeDebugMenu()
    }

    private fun initializeDebugMenu() = DebugMenu.initialize(
        application = this,
        applicationTitle = resourceProvider.strings.zilchDice,
        themeResourceId = R.style.ZilchDice
    )

    private fun initializeServiceLocator() = ServiceLocator.initializeModules {
        androidContext(this@ZilchDiceAndroidApp)
    }
}