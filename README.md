# Zilch Dice
Android, Linux, MacOS and Windows client apps for my interpretation of the popular game [Dice 10000](https://en.wikipedia.org/wiki/Dice_10000).

<img src="metadata/logo.png" width="10%"/>

It features a scalable UI that works across multiple screen sizes in dark and light themes and multiple language support.

## Table of Contents
- [How to build](#how-to-build)
- [Tech stack](#tech-stack)
- [Project architecture](#project-architecture)
  - [App folder](#app-folder)
  - [Features](#features)
  - [Other](#other)

## How to build

Clone the project and open it in the latest stable version of [Android Studio](https://developer.android.com/studio).

The IDE should recognize the entry points for the Android and Desktop apps, generating the proper Run configurations.

The Android app features `debug` and `release` build types (the latter being optimized and obfuscated, without a debug menu):

## Tech stack

The project uses [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html) to share a significant amount of code between JVM and Android. Most of the modules are pure
Kotlin so they can be reused on multiple platforms. Some parts of the data layer (such as database management) are written separately for Desktop and Android.

The UI is achieved using [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) but again, not all of the UI code is shared so that minor parts of the
interface can be optimized for the different platforms.

Some important third party libraries that are being used:

- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for asynchronous / reactive features
- [Koin](https://insert-koin.io/) for dependency injection (service locator)
- [Arbor](https://github.com/ToxicBakery/Arbor) for logging
- [Room](https://developer.android.com/jetpack/androidx/releases/room) for local storage on Android
- [Realm](https://realm.io/realm-kotlin/) for local storage on Desktop

## Project architecture

The main goal of the architecture is creating loosely coupled modules that encapsulate as many implementation details as possible, while only exposing a straightforward and small
API surface. Using SOLID principles when designing the modularization results in reduced build times due to Gradle's incremental builds, as well as a codebase that's easy to
navigate.

### App module

The `app` multiplatform module contains the entry points for the application on the different platforms. It handles opening the first screen and dependency injection.

### Features

Each feature folder can have its own `data`, `domain` and `presentation` subdirectory.
These can have modules for different platforms (`android`, `desktop` or `common`) or for `api` and `implementation`.
The app has the following features:

- `feature-game` - Responsible for the actual gameplay screen.
- `feature-menu` - The main menu screen.
- `feature-settings` - The settings screen.

### Other

- The `gradle` folder contains build scripts and related data.
- The `metadata` folder contains images needed for this documentation.
- The `shared` folder contains app-specific features used by multiple flows.
- The `utilities` folder contains helper functions that are not specific to the application.