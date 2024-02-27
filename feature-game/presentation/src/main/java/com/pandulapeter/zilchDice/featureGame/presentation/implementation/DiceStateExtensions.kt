package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.runtime.Composable
import com.pandulapeter.zilchDice.featureGame.data.RolledDie
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters

@Composable
internal fun RolledDie.painter(
    painters: Painters,
) = when (side) {
    RolledDie.Side.ONE -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_1_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_1_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_1_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_1_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_1_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_1_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_1_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_1_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_1_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_1_9
    }

    RolledDie.Side.TWO -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_2_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_2_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_2_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_2_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_2_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_2_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_2_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_2_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_2_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_2_9
    }

    RolledDie.Side.THREE -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_3_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_3_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_3_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_3_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_3_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_3_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_3_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_3_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_3_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_3_9
    }

    RolledDie.Side.FOUR -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_4_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_4_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_4_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_4_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_4_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_4_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_4_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_4_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_4_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_4_9
    }

    RolledDie.Side.FIVE -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_5_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_5_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_5_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_5_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_5_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_5_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_5_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_5_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_5_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_5_9
    }

    RolledDie.Side.SIX -> when (imageIndex) {
        RolledDie.ImageIndex.INDEX_0 -> painters.die_6_0
        RolledDie.ImageIndex.INDEX_1 -> painters.die_6_1
        RolledDie.ImageIndex.INDEX_2 -> painters.die_6_2
        RolledDie.ImageIndex.INDEX_3 -> painters.die_6_3
        RolledDie.ImageIndex.INDEX_4 -> painters.die_6_4
        RolledDie.ImageIndex.INDEX_5 -> painters.die_6_5
        RolledDie.ImageIndex.INDEX_6 -> painters.die_6_6
        RolledDie.ImageIndex.INDEX_7 -> painters.die_6_7
        RolledDie.ImageIndex.INDEX_8 -> painters.die_6_8
        RolledDie.ImageIndex.INDEX_9 -> painters.die_6_9
    }
}

@Composable
internal fun RolledDie.topPainter(
    painters: Painters,
) = when (side) {
    RolledDie.Side.ONE -> painters.die_1_top
    RolledDie.Side.TWO -> painters.die_2_top
    RolledDie.Side.THREE -> painters.die_3_top
    RolledDie.Side.FOUR -> painters.die_4_top
    RolledDie.Side.FIVE -> painters.die_5_top
    RolledDie.Side.SIX -> painters.die_6_top
}

internal val RolledDie.ImageIndex.mirror
    get() = when (this) {
        RolledDie.ImageIndex.INDEX_0 -> RolledDie.ImageIndex.INDEX_5
        RolledDie.ImageIndex.INDEX_1 -> RolledDie.ImageIndex.INDEX_6
        RolledDie.ImageIndex.INDEX_2 -> RolledDie.ImageIndex.INDEX_7
        RolledDie.ImageIndex.INDEX_3 -> RolledDie.ImageIndex.INDEX_8
        RolledDie.ImageIndex.INDEX_4 -> RolledDie.ImageIndex.INDEX_9
        RolledDie.ImageIndex.INDEX_5 -> RolledDie.ImageIndex.INDEX_0
        RolledDie.ImageIndex.INDEX_6 -> RolledDie.ImageIndex.INDEX_1
        RolledDie.ImageIndex.INDEX_7 -> RolledDie.ImageIndex.INDEX_2
        RolledDie.ImageIndex.INDEX_8 -> RolledDie.ImageIndex.INDEX_3
        RolledDie.ImageIndex.INDEX_9 -> RolledDie.ImageIndex.INDEX_4
    }