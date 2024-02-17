package com.pandulapeter.zilchDice.featureGame.presentation.implementation

internal data class DiceState(
    val side: Side,
    val imageIndex: ImageIndex,
) {
    enum class Side {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX;
    }

    enum class ImageIndex {
        INDEX_0,
        INDEX_1,
        INDEX_2,
        INDEX_3,
        INDEX_4,
        INDEX_5,
        INDEX_6,
        INDEX_7,
        INDEX_8,
        INDEX_9;
    }
}