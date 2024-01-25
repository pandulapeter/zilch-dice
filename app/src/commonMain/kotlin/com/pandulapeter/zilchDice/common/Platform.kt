package com.pandulapeter.zilchDice.common

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform