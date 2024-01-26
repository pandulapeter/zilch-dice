package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import android.content.Context
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types.StringsImpl
import dev.icerock.moko.resources.desc.ResourceStringDesc
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module

internal actual fun Module.defineStringResolver() = single<StringsImpl.StringResolver> { AndroidStringResolver(androidContext()) }

private class AndroidStringResolver(private val context: Context) : StringsImpl.StringResolver {
    override fun resolve(reference: ResourceStringDesc) = reference.toString(context)
}
