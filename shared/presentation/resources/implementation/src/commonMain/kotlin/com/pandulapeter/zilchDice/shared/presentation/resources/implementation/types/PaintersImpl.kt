package com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types

import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.MR
import dev.icerock.moko.resources.compose.painterResource

internal class PaintersImpl : Painters {

    override val dice @Composable get() = painterResource(MR.images.img_dice)
}