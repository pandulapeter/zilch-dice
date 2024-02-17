package com.pandulapeter.zilchDice.featureGame.presentation

import com.pandulapeter.zilchDice.featureGame.presentation.implementation.GameViewModel
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import org.koin.dsl.module

val gamePresentationModule = module {
    single { GameViewModel(get()) }
    single { RandomGenerator() }
}