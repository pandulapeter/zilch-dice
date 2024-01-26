package com.pandulapeter.zilchDice.common

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.featureMainMenu.presentation.MainMenu
import com.pandulapeter.zilchDice.shared.presentation.catalog.ZilchDiceTheme
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.logger.Logger
import org.koin.java.KoinJavaComponent

@Composable
internal fun App(
    resourceProvider: ResourceProvider = KoinJavaComponent.get(ResourceProvider::class.java),
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) {
        Logger.log("UI initialized.")
    }
    ZilchDiceTheme(
        resourceProvider = resourceProvider
    ) { paddingValues ->
        MainMenu(modifier = modifier.padding(paddingValues))
    }
}