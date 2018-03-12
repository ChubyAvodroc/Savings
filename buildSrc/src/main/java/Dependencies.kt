object Versions {
    val android_gradle_plugin = "3.0.1"
    val kotlin = "1.2.21"

    val minSdk = 17
    val targetSdk = 26
    val compileSdk = 26
    val versionCode = 1
    val versionName = "1.0"

    val support_library = "26.1.0"
    val constraint_layout = "1.0.2"

    val junit = "4.12"
    val test_runner = "1.0.1"
    val espresso = "3.0.1"
}

object Deps {
    //    Plugins
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //    Kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"

    //    Android
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_library}"
    val support_constraint_layout =
        "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"

}

object Testing {
    //    JUnit
    val junit = "junit:junit:${Versions.junit}"

    //    Runner
    val runner = "com.android.support.test:runner:${Versions.test_runner}"

    //    Espresso
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
}