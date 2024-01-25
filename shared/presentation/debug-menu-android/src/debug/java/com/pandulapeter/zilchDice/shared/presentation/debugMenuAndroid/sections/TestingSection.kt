package com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections

import com.pandulapeter.beagle.modules.AnimationDurationSwitchModule
import com.pandulapeter.beagle.modules.DividerModule
import com.pandulapeter.beagle.modules.KeylineOverlaySwitchModule
import com.pandulapeter.beagle.modules.PaddingModule
import com.pandulapeter.beagle.modules.TextModule
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.insetHandler

internal fun createTestingSection() = listOf(
    TextModule(
        text = "Testing",
        type = TextModule.Type.SECTION_HEADER
    ),
    KeylineOverlaySwitchModule(
        applyInsets = insetHandler
    ),
    AnimationDurationSwitchModule(),
    PaddingModule(),
    DividerModule()
)
