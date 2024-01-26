package com.pandulapeter.zilchDice.common

import com.pandulapeter.zilchDice.shared.presentation.navigator.Navigator
import org.koin.dsl.module

internal val appModule = module {
    single<Navigator> { NavigatorImpl() }
}