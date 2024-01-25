package com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections

import com.pandulapeter.beagle.common.configuration.toText
import com.pandulapeter.beagle.modules.LogListModule
import com.pandulapeter.beagle.modules.TextModule
import com.pandulapeter.zilchDice.utilities.logger.Logger

internal fun createLogsSection() = listOf(
    TextModule(
        text = "Logs",
        type = TextModule.Type.SECTION_HEADER
    ),
    LogListModule(
        title = "General logs".toText(),
        label = Logger.Level.GENERAL.id,
        maxItemCount = MAX_ITEM_COUNT
    ),
    LogListModule(
        title = "Data logs".toText(),
        label = Logger.Level.DATA.id,
        maxItemCount = MAX_ITEM_COUNT
    ),
    LogListModule(
        title = "UI logs".toText(),
        label = Logger.Level.UI.id,
        maxItemCount = MAX_ITEM_COUNT
    ),
    LogListModule(
        title = "All logs".toText(),
        maxItemCount = MAX_ITEM_COUNT
    )
)

private const val MAX_ITEM_COUNT = 25