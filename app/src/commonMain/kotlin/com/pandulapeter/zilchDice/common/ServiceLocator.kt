package com.pandulapeter.zilchDice.common

import com.pandulapeter.zilchDice.featureGame.presentation.gamePresentationModule
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.sharedPresentationResourcesModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

internal object ServiceLocator {

    private val zilchDiceModules by lazy {
        listOf(
            gamePresentationModule,
            sharedPresentationResourcesModule,
            appModule
        )
    }

    fun initializeModules(
        initializationAction: KoinApplication.() -> Unit = {}
    ) = startKoin {
        initializationAction()
        modules(zilchDiceModules)
    }
}