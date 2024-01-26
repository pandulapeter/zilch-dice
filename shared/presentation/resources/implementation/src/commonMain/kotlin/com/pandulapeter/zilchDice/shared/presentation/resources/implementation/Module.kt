package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Colors
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Painters
import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Strings
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types.ColorsImpl
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types.PaintersImpl
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types.StringsImpl
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.dsl.module

val sharedPresentationResourcesModule = module {
    defineStringResolver()
    single<Colors> { ColorsImpl() }
    single<Painters> { PaintersImpl() }
    single<Strings> { StringsImpl(get()) }
    single<ResourceProvider> { ResourceProviderImpl(get(), get(), get()) }
}

internal expect fun Module.defineStringResolver(): KoinDefinition<StringsImpl.StringResolver>