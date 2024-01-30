package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters

@Composable
internal fun DiceState.painter(
    painters: Painters,
) = when (side) {
    DiceState.Side.ONE -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_1_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_1_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_1_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_1_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_1_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_1_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_1_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_1_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_1_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_1_9
    }

    DiceState.Side.TWO -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_2_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_2_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_2_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_2_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_2_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_2_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_2_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_2_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_2_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_2_9
    }

    DiceState.Side.THREE -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_3_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_3_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_3_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_3_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_3_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_3_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_3_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_3_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_3_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_3_9
    }

    DiceState.Side.FOUR -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_4_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_4_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_4_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_4_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_4_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_4_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_4_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_4_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_4_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_4_9
    }

    DiceState.Side.FIVE -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_5_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_5_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_5_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_5_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_5_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_5_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_5_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_5_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_5_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_5_9
    }

    DiceState.Side.SIX -> when (imageIndex) {
        DiceState.ImageIndex.INDEX_0 -> painters.dice_6_0
        DiceState.ImageIndex.INDEX_1 -> painters.dice_6_1
        DiceState.ImageIndex.INDEX_2 -> painters.dice_6_2
        DiceState.ImageIndex.INDEX_3 -> painters.dice_6_3
        DiceState.ImageIndex.INDEX_4 -> painters.dice_6_4
        DiceState.ImageIndex.INDEX_5 -> painters.dice_6_5
        DiceState.ImageIndex.INDEX_6 -> painters.dice_6_6
        DiceState.ImageIndex.INDEX_7 -> painters.dice_6_7
        DiceState.ImageIndex.INDEX_8 -> painters.dice_6_8
        DiceState.ImageIndex.INDEX_9 -> painters.dice_6_9
    }
}

internal val DiceState.ImageIndex.mirror
    get() = when (this) {
        DiceState.ImageIndex.INDEX_0 -> DiceState.ImageIndex.INDEX_5
        DiceState.ImageIndex.INDEX_1 -> DiceState.ImageIndex.INDEX_6
        DiceState.ImageIndex.INDEX_2 -> DiceState.ImageIndex.INDEX_7
        DiceState.ImageIndex.INDEX_3 -> DiceState.ImageIndex.INDEX_8
        DiceState.ImageIndex.INDEX_4 -> DiceState.ImageIndex.INDEX_9
        DiceState.ImageIndex.INDEX_5 -> DiceState.ImageIndex.INDEX_0
        DiceState.ImageIndex.INDEX_6 -> DiceState.ImageIndex.INDEX_1
        DiceState.ImageIndex.INDEX_7 -> DiceState.ImageIndex.INDEX_2
        DiceState.ImageIndex.INDEX_8 -> DiceState.ImageIndex.INDEX_3
        DiceState.ImageIndex.INDEX_9 -> DiceState.ImageIndex.INDEX_4
    }