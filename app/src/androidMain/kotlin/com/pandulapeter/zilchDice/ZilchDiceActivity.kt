package com.pandulapeter.zilchDice

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.common.App

class ZilchDiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(
                modifier = Modifier
                    .systemBarsPadding()
                    .imePadding(),
            )
        }
    }
}