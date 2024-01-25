package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import dev.icerock.moko.resources.compose.painterResource

internal class ResourceProviderImpl : ResourceProvider {

    @Composable
    override fun DicePainter() = painterResource(MR.images.img_dice)
}