package com.pandulapeter.zilchDice.shared.presentation.navigator


sealed class NavigationDestination {

    data object MainMenu : NavigationDestination()

    data object Game : NavigationDestination()
}