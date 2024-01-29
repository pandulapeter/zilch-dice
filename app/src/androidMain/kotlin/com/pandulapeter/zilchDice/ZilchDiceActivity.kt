package com.pandulapeter.zilchDice

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.common.App
import com.pandulapeter.zilchDice.shared.presentation.navigator.NavigationDestination
import com.pandulapeter.zilchDice.shared.presentation.navigator.Navigator
import org.koin.android.ext.android.inject

class ZilchDiceActivity : AppCompatActivity() {

    private val navigator by inject<Navigator>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val currentDestination = navigator.currentDestination.collectAsState(NavigationDestination.MainMenu)
            BackHandler(currentDestination.value != NavigationDestination.MainMenu) { navigator.navigateBack() }
            App(
                modifier = Modifier
                    .systemBarsPadding()
                    .imePadding(),
            )
        }
    }
}