package com.pandulapeter.zilchDice.shared.presentation.navigator


sealed class NavigationDestination {

    data object Game : NavigationDestination()

    data object MainMenu : NavigationDestination()

    data object Settings : NavigationDestination()
}