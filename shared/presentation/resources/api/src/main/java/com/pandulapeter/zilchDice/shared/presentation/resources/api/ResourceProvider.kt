package com.pandulapeter.zilchDice.shared.presentation.resources.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

interface ResourceProvider {

    @Composable
    fun DicePainter(): Painter
}