package com.pandulapeter.zilchDice.shared.presentation.resources.implementation

import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import org.koin.dsl.module

val sharedPresentationResourcesModule = module {
    single<ResourceProvider> { ResourceProviderImpl() }
}