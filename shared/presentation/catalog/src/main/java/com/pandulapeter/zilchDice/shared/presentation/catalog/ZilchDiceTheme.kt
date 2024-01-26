package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider

@Composable
fun ZilchDiceTheme(
    resourceProvider: ResourceProvider,
    content: @Composable () -> Unit
) = MaterialTheme(
    colors = if (isSystemInDarkTheme()) darkColors(
        primary = resourceProvider.colors.brand
    ) else lightColors(
        primary = resourceProvider.colors.brand
    ),
    content = content
)