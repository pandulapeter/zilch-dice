package com.pandulapeter.zilchDice.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.logger.Logger
import org.koin.java.KoinJavaComponent

@Composable
fun App(
    resourceProvider: ResourceProvider = KoinJavaComponent.get(ResourceProvider::class.java)
) {
    LaunchedEffect(Unit) {
        Logger.log("App started.")
    }
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = resourceProvider.colors.brand),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = resourceProvider.painters.dice,
                contentDescription = null
            )
            Button(onClick = { showContent = !showContent }) {
                Text(resourceProvider.strings.menuStartGame)
            }
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = resourceProvider.painters.dice,
                        contentDescription = null
                    )
                    Text("Compose: $greeting")
                }
            }
        }
    }
}