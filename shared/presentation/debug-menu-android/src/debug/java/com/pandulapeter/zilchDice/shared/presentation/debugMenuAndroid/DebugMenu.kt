package com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid

import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.annotation.StyleRes
import com.pandulapeter.beagle.Beagle
import com.pandulapeter.beagle.common.configuration.Appearance
import com.pandulapeter.beagle.common.configuration.Behavior
import com.pandulapeter.beagle.common.configuration.toText
import com.pandulapeter.beagle.logCrash.BeagleCrashLogger
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections.createGeneralSection
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections.createHeaderSection
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections.createLogsSection
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections.createShortcutsSection
import com.pandulapeter.zilchDice.shared.presentation.debugMenuAndroid.sections.createTestingSection
import com.pandulapeter.zilchDice.utilities.logger.Logger

object DebugMenu : DebugMenuContract {

    override fun initialize(
        application: Application,
        applicationTitle: String,
        @StyleRes themeResourceId: Int
    ) {
        val packageInfo = with(application) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
                } else {
                    @Suppress("DEPRECATION")
                    packageManager.getPackageInfo(packageName, 0)
                }
            } catch (_: PackageManager.NameNotFoundException) {
                null
            }
        }
        Beagle.initialize(
            application = application,
            appearance = Appearance(
                themeResourceId = themeResourceId,
                applyInsets = insetHandler
            ),
            behavior = Behavior(
                shakeDetectionBehavior = Behavior.ShakeDetectionBehavior(
                    threshold = null
                ),
                bugReportingBehavior = Behavior.BugReportingBehavior(
                    buildInformation = {
                        listOf(
                            "Package Name".toText() to application.packageName,
                            "Version Name".toText() to packageInfo?.versionName.orEmpty(),
                            "Version Code".toText() to (packageInfo?.versionCode ?: 0).toString()
                        )
                    },
                    logLabelSectionsToShow = emptyList(),
                    crashLoggers = listOf(BeagleCrashLogger),
                    emailAddress = "pandulapeter@gmail.com"
                )
            )
        )
        initializeLogging()
        Beagle.set(
            modules = (createHeaderSection(
                applicationTitle = applicationTitle,
                packageName = application.packageName,
                versionName = packageInfo?.versionName.orEmpty(),
                versionCode = packageInfo?.versionCode ?: 0
            ) + createGeneralSection(
            ) + createShortcutsSection(
            ) + createTestingSection(
            ) + createLogsSection(
            )).toTypedArray()
        )
        Logger.log("Debug menu initialized.", Logger.Level.UI)
    }

    private fun initializeLogging() = Logger.addListener { message, level, tag ->
        Beagle.log(
            label = level.id,
            message = message
        )
        Log.d(tag, "${level.id} | $message")
    }
}