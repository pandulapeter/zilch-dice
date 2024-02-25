package com.pandulapeter.zilchDice

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.pandulapeter.zilchDice.common.App
import com.pandulapeter.zilchDice.common.ServiceLocator
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject
import com.pandulapeter.zilchDice.utilities.logger.Logger
import java.awt.Dimension

fun main() = application {
    initializeServiceLocator()
    val resourceProvider = inject<ResourceProvider>()
    Window(
        onCloseRequest = ::exitApplication,
        title = resourceProvider.strings.zilchDice
    ) {
        window.minimumSize = Dimension(320, 320)
        LaunchedEffect(Unit) {
            Logger.addListener { message, level, tag -> println("$tag | ${level.id} | $message") }
        }
        App()
    }
}

private fun initializeServiceLocator() = ServiceLocator.initializeModules()