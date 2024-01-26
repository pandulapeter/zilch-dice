package com.pandulapeter.zilchDice.shared.presentation.resources.api

import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Colors
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Strings

interface ResourceProvider {

    val colors: Colors
    val painters: Painters
    val strings: Strings
}