package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types.StringsImpl
import dev.icerock.moko.resources.desc.ResourceStringDesc
import org.koin.core.module.Module

internal actual fun Module.defineStringResolver() = single<StringsImpl.StringResolver> { DesktopStringResolver() }

private class DesktopStringResolver : StringsImpl.StringResolver {
    override fun resolve(reference: ResourceStringDesc) = reference.localized()
}