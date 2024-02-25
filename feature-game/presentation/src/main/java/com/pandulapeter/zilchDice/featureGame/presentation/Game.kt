package com.pandulapeter.zilchDice.featureGame.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui.GameBoard
import com.pandulapeter.zilchDice.shared.presentation.catalog.ZilchDiceButton
import com.pandulapeter.zilchDice.shared.presentation.navigator.NavigationDestination
import com.pandulapeter.zilchDice.shared.presentation.navigator.Navigator
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject
import com.pandulapeter.zilchDice.utilities.logger.Logger

@Composable
fun Game(
    resourceProvider: ResourceProvider = inject(),
    navigator: Navigator = inject(),
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        Logger.log("Game: Initialized.")
    }

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GameBoard()
            ZilchDiceButton(
                text = resourceProvider.strings.gameReturnToMainMenu,
                onClick = {
                    Logger.log("Game: 'Return to Main Menu' button clicked.")
                    navigator.setDestination(NavigationDestination.MainMenu)
                }
            )
        }
    }
}