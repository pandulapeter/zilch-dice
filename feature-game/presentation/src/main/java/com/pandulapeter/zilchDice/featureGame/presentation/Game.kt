package com.pandulapeter.zilchDice.featureGame.presentation

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        Logger.log("Game initialized.")
    }

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = resourceProvider.painters.dice,
                contentDescription = null
            )
            Button(
                onClick = {
                    navigator.setDestination(NavigationDestination.MainMenu)
                    Logger.log("'Return to Main Menu' button clicked.")
                }
            ) {
                Text(resourceProvider.strings.gameReturnToMainMenu)
            }
        }
    }
}

@Preview
@Composable
private fun preview() = Game()