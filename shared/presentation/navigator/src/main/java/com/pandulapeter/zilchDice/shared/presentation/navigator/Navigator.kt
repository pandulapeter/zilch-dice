package com.pandulapeter.zilchDice.shared.presentation.navigator

import kotlinx.coroutines.flow.StateFlow


interface Navigator {

    val currentDestination: StateFlow<NavigationDestination>

    fun setDestination(newDestination: NavigationDestination)
}