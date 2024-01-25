package com.pandulapeter.zilchDice

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.pandulapeter.zilchDice.common.App
import com.pandulapeter.zilchDice.common.ServiceLocator
import com.pandulapeter.zilchDice.utilities.logger.Logger

fun main() = application {
    initializeServiceLocator()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Zilch Dice"
    ) {
        LaunchedEffect(Unit) {
            Logger.addListener { message, level, tag -> println("$tag | ${level.id} | $message") }
        }
        App()
    }
}

private fun initializeServiceLocator() = ServiceLocator.initializeModules()