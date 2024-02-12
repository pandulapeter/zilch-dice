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

    // Game
    override val game = MR.strings.game.resolve()
    override val gameRoll = MR.strings.game_roll.resolve()
    override val gameReturnToMainMenu = MR.strings.game_return_to_main_menu.resolve()

    // Main menu
    override val mainMenu = MR.strings.main_menu.resolve()
    override val mainMenuStartGame = MR.strings.main_menu_start_game.resolve()
    override val mainMenuSettings = MR.strings.main_menu_settings.resolve()

    // Game
    override val settings = MR.strings.settings.resolve()
    override val settingsReturnToMainMenu = MR.strings.settings_return_to_main_menu.resolve()

    interface StringResolver {

        fun resolve(reference: ResourceStringDesc): String
    }

    private fun StringResource.resolve() = stringResolver.resolve(StringDesc.Resource((this)))
}