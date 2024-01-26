package com.pandulapeter.zilchDice.utilities.extensions

import org.koin.java.KoinJavaComponent

inline fun <reified T> inject(): T = KoinJavaComponent.get(T::class.java)