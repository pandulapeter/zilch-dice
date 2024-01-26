package com.pandulapeter.zilchDice.featureMainMenu.presentation

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import org.koin.java.KoinJavaComponent

@Composable
fun MainMenu(
    resourceProvider: ResourceProvider = KoinJavaComponent.get(ResourceProvider::class.java),
    modifier: Modifier = Modifier
) = Box(
    modifier = modifier
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

@Preview
@Composable
private fun preview() = MainMenu()