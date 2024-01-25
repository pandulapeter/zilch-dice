package com.pandulapeter.zilchDice.utilities.logger

import com.toxicbakery.logging.Arbor
import com.toxicbakery.logging.ISeedling

object Logger {

    enum class Level(val id: String) {
        GENERAL("General"),
        DATA("Data"),
        UI("UI");

        companion object {
            fun fromId(id: String) = entries.firstOrNull { it.id == id } ?: GENERAL
        }
    }

    fun log(
        message: String,
        level: Level = Level.GENERAL
    ) = Arbor.d("${level.id}|$message")

    fun addListener(
        listener: (
            message: String,
            level: Level,
            tag: String,
        ) -> Unit
    ) = Arbor.sow(
        object : ISeedling {

            override val tag = "ZilchDice-logs"

            override fun log(
                level: Int,
                tag: String,
                msg: String,
                throwable: Throwable?,
                args: Array<out Any?>?
            ) = msg.split("|").let {
                listener(it.last(), Level.fromId(it.first()), tag)
            }
        }
    )
}