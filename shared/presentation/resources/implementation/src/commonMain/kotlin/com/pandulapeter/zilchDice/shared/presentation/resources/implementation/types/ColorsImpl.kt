package com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types

import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Colors
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.MR
import dev.icerock.moko.resources.compose.colorResource

internal class ColorsImpl : Colors {

    override val brand @Composable get() = colorResource(MR.colors.brand)
}