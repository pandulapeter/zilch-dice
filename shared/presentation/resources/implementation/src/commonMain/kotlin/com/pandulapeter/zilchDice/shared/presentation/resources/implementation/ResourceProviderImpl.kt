package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Colors
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Strings

internal data class ResourceProviderImpl(
    override val colors: Colors,
    override val painters: Painters,
    override val strings: Strings,
) : ResourceProvider