package com.pandulapeter.zilchDice.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    ) {
        Scaffold { paddingValues ->
            Box(
                modifier = modifier.padding(paddingValues)
            ) {
                var showContent by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = resourceProvider.painters.dice,
                        contentDescription = null
                    )
                    Button(onClick = { showContent = !showContent }) {
                        Text(resourceProvider.strings.menuStartGame)
                    }
                    AnimatedVisibility(showContent) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = resourceProvider.painters.dice,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}