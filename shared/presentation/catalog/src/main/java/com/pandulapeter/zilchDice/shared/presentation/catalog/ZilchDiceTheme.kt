package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider

@Composable
fun ZilchDiceTheme(
    resourceProvider: ResourceProvider,
    content: @Composable (PaddingValues) -> Unit
) = MaterialTheme(
    colors = if (isSystemInDarkTheme()) darkColors(
        primary = resourceProvider.colors.brand,
        onPrimary = Color.White
    ) else lightColors(
        primary = resourceProvider.colors.brand
    )
) {
    Scaffold { paddingValues ->
        content(paddingValues)
    }
}