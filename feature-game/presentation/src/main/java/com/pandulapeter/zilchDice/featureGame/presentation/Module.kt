package com.pandulapeter.zilchDice.featureGame.presentation

import com.pandulapeter.zilchDice.featureGame.presentation.implementation.GameViewModel
import org.koin.dsl.module

val gamePresentationModule = module {
    single { GameViewModel() }
}