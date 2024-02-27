package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.data.RolledDie


@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DieRow(
    modifier: Modifier = Modifier,
    rolledDice: List<RolledDie>,
    onDieSelected: (Int) -> Unit
) = Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    LazyVerticalGrid(
        modifier = Modifier.sizeIn(maxWidth = 720.dp),
        columns = GridCells.Fixed(rolledDice.size),
    ) {
        items(
            count = rolledDice.size,
            key = { rolledDice[it].id }
        ) {
            Die(
                modifier = Modifier.animateItemPlacement(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease,
                    )
                ),
                rolledDie = rolledDice[it],
                onDiceSelected = onDieSelected
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SavedDieRow(
    modifier: Modifier = Modifier.fillMaxWidth(),
    savedDice: List<RolledDie>,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 48.dp)
) {
    AnimatedVisibility(
        modifier = Modifier.fillMaxWidth(),
        visible = savedDice.any { it.isSaved },
        enter = fadeIn() + scaleIn(),
        exit = scaleOut() + fadeOut()
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            items(
                items = savedDice,
                key = { it.id }
            ) { rolledDie ->
                SavedDie(
                    modifier = Modifier.animateItemPlacement(
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = Ease,
                        )
                    ),
                    rolledDie = rolledDie
                )
            }
        }
    }
}