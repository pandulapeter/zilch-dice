package com.pandulapeter.zilchDice.common

import com.pandulapeter.zilchDice.shared.presentation.navigator.NavigationDestination
import com.pandulapeter.zilchDice.shared.presentation.navigator.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class NavigatorImpl : Navigator {

    private val _currentDestination = MutableStateFlow<NavigationDestination>(NavigationDestination.MainMenu)
    override val currentDestination = _currentDestination.asStateFlow()

    override fun setDestination(newDestination: NavigationDestination) {
        _currentDestination.value = newDestination
    }
}