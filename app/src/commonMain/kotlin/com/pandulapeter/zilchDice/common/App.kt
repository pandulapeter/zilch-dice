package com.pandulapeter.zilchDice.common

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.featureGame.presentation.Game
import com.pandulapeter.zilchDice.featureMainMenu.presentation.MainMenu
import com.pandulapeter.zilchDice.shared.presentation.catalog.ZilchDiceTheme
import com.pandulapeter.zilchDice.shared.presentation.navigator.NavigationDestination
import com.pandulapeter.zilchDice.shared.presentation.navigator.Navigator
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject
import com.pandulapeter.zilchDice.utilities.logger.Logger

@Composable
internal fun App(
    resourceProvider: ResourceProvider = inject(),
    navigator: Navigator = inject(),
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) {
        Logger.log("UI initialized.")
    }

    val currentDestination = navigator.currentDestination.collectAsState(NavigationDestination.MainMenu)
    ZilchDiceTheme(
        resourceProvider = resourceProvider
    ) { paddingValues ->
        when (currentDestination.value) {
            NavigationDestination.MainMenu -> MainMenu(
                modifier = modifier.padding(paddingValues)
            )
            NavigationDestination.Game -> Game(
                modifier = modifier.padding(paddingValues)
            )
        }
    }
}