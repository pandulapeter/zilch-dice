package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.featureGame.data.DiceState
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.painter
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject

@Composable
internal fun Dice(
    resourceProvider: ResourceProvider = inject(),
    randomGenerator: RandomGenerator = inject(),
    diceState: DiceState,
    modifier: Modifier = Modifier,
) = AnimatedContent(
    modifier = modifier,
    targetState = diceState,
    transitionSpec = { createRollContentTransform(randomGenerator) },
) {
    Image(
        painter = it.painter(
            painters = resourceProvider.painters,
        ),
        contentDescription = null,
    )
}

private fun createRollContentTransform(
    randomGenerator: RandomGenerator
): ContentTransform {
    val duration = randomGenerator.intBetween(200, 100)
    val delay = randomGenerator.intBetween(10, 80)
    val inAnimation = fadeIn(
        animationSpec = tween(durationMillis = duration, delayMillis = delay)
    ) + scaleIn(
        animationSpec = tween(durationMillis = duration * 2),
        initialScale = 0.5f
    )
    val outAnimation = fadeOut(
        animationSpec = tween(durationMillis = duration)
    ) + scaleOut(
        animationSpec = tween(durationMillis = duration / 2),
        targetScale = 0.5f
    )
    return inAnimation togetherWith outAnimation
}