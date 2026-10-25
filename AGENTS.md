# AGENTS

A Kotlin Multiplatform app for Android and iOS. Build and test it with the `lim` CLI, not a local
Gradle build, Android Studio, local Xcode, or a local simulator. `lim` builds on remote Gradle and
Xcode sandboxes and runs the app on cloud Android emulators and iOS simulators.

- Android application ID: `com.limrun.samplekotlinmultiplatformapp`
- iOS bundle ID: `com.limrun.samples.sample-kotlin-multiplatform-app`, scheme `iosApp`

Install `lim` and the Limrun skills:

```bash
npm install --global lim
lim skills install
```

`lim` reads `LIM_API_KEY` from the environment or a `.env` file.

## Android

Build the debug APK on a remote Gradle sandbox and upload it to Limrun asset storage:

```bash
lim gradle build . --task :androidApp:assembleDebug --upload sample-kotlin-multiplatform-app/android-debug.apk
```

Get an emulator with the APK installed, then launch the app:

```bash
lim android create --install-asset sample-kotlin-multiplatform-app/android-debug.apk
lim android launch-app com.limrun.samplekotlinmultiplatformapp --detach
```

## iOS

Build on a remote Xcode sandbox, then attach a simulator. `--attach` installs and launches the
latest build, and each later `lim xcode build` reinstalls it:

```bash
lim xcode build . --project iosApp/iosApp.xcodeproj --scheme iosApp
lim ios create --attach
```

## Test and clean up

Drive the app with `lim android …` or `lim ios …` commands (element tree, tap, type, screenshot,
app log). Record a video for the user with `record start` and `record stop -o recording.mp4`.
Delete each instance when you finish, with `lim android delete <id>` or `lim ios delete <id>`.
