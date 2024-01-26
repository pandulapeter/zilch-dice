package com.pandulapeter.zilchDice.shared.presentation.resources.implementation.types

import com.pandulapeter.zilchDice.shared.presentation.resources.api.types.Strings
import com.pandulapeter.zilchDice.shared.presentation.resources.implementation.MR
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.ResourceStringDesc
import dev.icerock.moko.resources.desc.StringDesc

internal class StringsImpl(
    private val stringResolver: StringResolver
) : Strings {

    // General
    override val zilchDice = MR.strings.zilch_dice.resolve()

    // Menu
    override val menuStartGame = MR.strings.menu_start_game.resolve()

    interface StringResolver {

        fun resolve(reference: ResourceStringDesc): String
    }

    private fun StringResource.resolve() = stringResolver.resolve(StringDesc.Resource((this)))
}