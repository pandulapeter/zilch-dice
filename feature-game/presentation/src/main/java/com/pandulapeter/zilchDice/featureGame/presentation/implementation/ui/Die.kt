package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.data.RolledDie
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.painter
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.topPainter
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject

@Composable
internal fun Die(
    resourceProvider: ResourceProvider = inject(),
    randomGenerator: RandomGenerator = inject(),
    modifier: Modifier = Modifier,
    rolledDie: RolledDie,
    onDiceSelected: (Int) -> Unit,
) = Box(
    modifier = modifier
) {
    AnimatedContent(
        targetState = rolledDie.side to rolledDie.imageIndex,
        transitionSpec = { createRollContentTransform(randomGenerator) },
    ) {
        Card(
            shape = CircleShape,
            elevation = 0.dp
        ) {
            Image(
                modifier = Modifier.clickable { onDiceSelected(rolledDie.id) }.alpha(if (rolledDie.isSaved) 0.5f else 1f),
                painter = rolledDie.painter(
                    painters = resourceProvider.painters,
                ),
                contentDescription = null
            )
        }
    }
    AnimatedVisibility(
        visible = rolledDie.isSaved,
        enter = fadeIn() + scaleIn(),
        exit = scaleOut() + fadeOut()
    ) {
        Image(
            imageVector = Icons.Default.Lock,
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
        )
    }
}

@Composable
internal fun SavedDie(
    resourceProvider: ResourceProvider = inject(),
    modifier: Modifier = Modifier,
    rolledDie: RolledDie
) = Image(
    modifier = modifier
        .sizeIn(
            maxWidth = 48.dp,
            maxHeight = 48.dp
        )
        .padding(4.dp),
    painter = rolledDie.topPainter(
        painters = resourceProvider.painters,
    ),
    contentDescription = null
)

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
    val outAnimation = scaleOut(
        animationSpec = tween(durationMillis = duration / 2),
        targetScale = 0.5f
    ) + fadeOut(
        animationSpec = tween(durationMillis = duration)
    )
    return inAnimation togetherWith outAnimation
}