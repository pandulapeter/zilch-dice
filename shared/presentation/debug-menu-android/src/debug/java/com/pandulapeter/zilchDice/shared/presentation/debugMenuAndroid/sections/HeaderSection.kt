package com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections

import com.pandulapeter.beagle.modules.HeaderModule
import com.pandulapeter.beagle.modules.PaddingModule

internal fun createHeaderSection(
    applicationTitle: String,
    packageName: String,
    versionName: String,
    versionCode: Int
) = listOf(
    HeaderModule(
        title = applicationTitle,
        subtitle = "v$versionName ($versionCode)",
        text = packageName
    ),
    PaddingModule()
)